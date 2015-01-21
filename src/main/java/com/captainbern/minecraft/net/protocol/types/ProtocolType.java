package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.Side;
import com.captainbern.reflection.Reflection;

public enum ProtocolType {

    HANDSHAKE(HandshakeProtocol.class),
    STATUS(StatusProtocol.class),
    LOGIN(LoginProtocol.class),
    PLAY(PlayProtocol.class);

    private final Class<? extends MinecraftProtocol> protocolClass;

    private ProtocolType(Class<? extends MinecraftProtocol> protocolClass) {
        this.protocolClass = protocolClass;
    }

    public MinecraftProtocol createFor(Side side) {
        return new Reflection().reflect(protocolClass).newInstance(side);
    }
}
