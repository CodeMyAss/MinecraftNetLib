package com.captainbern.minecraft.net.handler.test;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.session.Session;
import com.captainbern.reflection.ClassTemplate;
import com.captainbern.reflection.Reflection;
import com.captainbern.reflection.accessor.MethodAccessor;
import com.google.common.collect.Maps;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HandlerLookup {

    private Map<Class<? extends Packet>, List<Handler<?, ?>>> LOOKUP = Maps.newConcurrentMap();

    public HandlerLookup() {}

    public <P extends Packet> List<Handler<?, ?>> getHandlersFor(Class<P> packet) {
        List<Handler<?, ?>> handlers = this.LOOKUP.get(packet);

        if (handlers == null) {
            handlers = new ArrayList<>();
            this.LOOKUP.put(packet, handlers);
        }

        return handlers;
    }

    public void register(String handlersPackage) {
        try {
            Set<ClassPath.ClassInfo> classes = ClassPath.from(MinecraftProtocol.class.getClassLoader()).getTopLevelClasses(handlersPackage);

            for (ClassPath.ClassInfo classInfo : classes) {
                Class<?> candidate = classInfo.load();

                if (candidate.isAnnotationPresent(PacketHandler.class))
                    register(((Class<Handler<?, ?>>) candidate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <P extends Packet, H extends Handler<?, P>> void register(Class<H> handler) {
        try {
            if (!handler.isAnnotationPresent(PacketHandler.class))
                throw new IllegalArgumentException("PacketHandler annotation is not present in Handler class: \'" + handler.getName() + "\'");

            PacketHandler packetHandler = handler.getAnnotation(PacketHandler.class);
            Class<? extends Packet> packetClass = packetHandler.value();

            Handler<?, P> handlerInstance;
            try {
                handlerInstance = handler.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create a new instance of Handler: \'" + handler.getName() + "\'");
            }

            Type[] types = handler.getGenericInterfaces();
            Class packetType = (Class) ((ParameterizedType) types[0]).getActualTypeArguments()[1];

            if (packetType != packetClass)
                throw new RuntimeException("Packet type in @PacketHandler (\'" + packetClass.getName() + "\') " +
                        "did not match the Packet parameter (\'" + packetType.getName() + "\')");

            List<Handler<?, ?>> handlers = this.getHandlersFor(packetClass);
            handlers.add(handlerInstance);

            this.LOOKUP.put(packetClass, handlers);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register Handler class: \'" + handler.getName() + "\'", e);
        }
    }
}
