package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.codec.handshake.client.CodecHandshake;
import com.captainbern.minecraft.net.packet.handshake.client.PacketHandshake;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.ProtocolState;
import com.captainbern.minecraft.net.protocol.Side;

public class HandshakeProtocol extends MinecraftProtocol {

    public HandshakeProtocol(Side side) {
        super(side, ProtocolState.HANDSHAKE);

        registerClient(0x0, PacketHandshake.class, CodecHandshake.class);
    }
}
