package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.protocol.MinecraftProtocol;

public enum ProtocolType {

    HANDSHAKE(new HandshakeProtocol()),
    STATUS(new StatusProtocol()),
    LOGIN(new LoginProtocol()),
    PLAY(new PlayProtocol());

    private final MinecraftProtocol minecraftProtocol;

    private ProtocolType(MinecraftProtocol minecraftProtocol) {
        this.minecraftProtocol = minecraftProtocol;
    }

    public MinecraftProtocol getMinecraftProtocol() {
        return this.minecraftProtocol;
    }
}
