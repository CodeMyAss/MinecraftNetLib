package com.captainbern.minecraft.net.handler;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.Protocol;
import com.google.common.collect.Maps;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class HandlerLookup {

    private final Map<Class<? extends Packet>, Handler> registry = Maps.newConcurrentMap();
    private final Protocol protocol;

    public HandlerLookup(Protocol protocol) {
        this.protocol = protocol;
    }

    public <P extends Packet> Handler<?, P> getHandler(Class<P> packetType) {
        if (this.registry.get(packetType) == null)
            return null;

        return this.registry.get(packetType);
    }

    public void registerHandlers(String packageName) {
        try {
            Set<ClassPath.ClassInfo> classes = ClassPath.from(MinecraftProtocol.class.getClassLoader()).getTopLevelClasses(packageName);

            for (ClassPath.ClassInfo classInfo : classes) {
                Class<?> clazz = classInfo.load();

                if (!Handler.class.isAssignableFrom(clazz))
                    continue;

                this.registerHandler(((Class<? extends Handler>) clazz));
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to register the handlers for package: \'" + packageName + "\'");
        }
    }

    public <P extends Packet, H extends Handler<?, P>> void registerHandler(Class<H> handlerClass) {
        if (!handlerClass.isAnnotationPresent(PacketHandler.class))
            throw new IllegalArgumentException("Handler: \'" + handlerClass.getName() + "\' does not have the required PacketHandler annotation!");

        Handler handler;
        try {
            handler = handlerClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create a new instance of handler class: \'" + handlerClass.getName() + "\'");
        }

        PacketHandler packetHandler = handlerClass.getAnnotation(PacketHandler.class);

        if (packetHandler.protocol().getMinecraftProtocol().getClass() != this.protocol.getClass())
            return;

        Class<? extends Packet> annotationPacketType = packetHandler.packet();

        Type[] types = handlerClass.getGenericInterfaces();
        Class genericPacketType = (Class) ((ParameterizedType) types[0]).getActualTypeArguments()[1];

        // Check if the packet-types match
        if (annotationPacketType != genericPacketType)
            throw new IllegalArgumentException("PacketType defined in @PacketHandler does not match the generic defined PacketType for handler: \'" + handlerClass.getName() + "\'");

        if (this.registry.get(annotationPacketType) != null)
            MinecraftProtocol.getLogger().warn("Overriding a handler for: \'" + annotationPacketType.getName() + "\'");

        this.registry.put(annotationPacketType, handler);
    }
}
