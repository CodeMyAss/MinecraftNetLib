package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.codec.handshake.client.CodecHandshake;
import com.captainbern.minecraft.net.packet.handshake.client.PacketHandshake;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.ProtocolState;

public class HandshakeProtocol extends MinecraftProtocol {

    public HandshakeProtocol() {
        super(ProtocolState.HANDSHAKE);

        registerClient(0x0, PacketHandshake.class, CodecHandshake.class);
    }
}
