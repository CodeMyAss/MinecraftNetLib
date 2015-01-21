package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.codec.status.client.CodecPing;
import com.captainbern.minecraft.net.codec.status.client.CodecStatusRequest;
import com.captainbern.minecraft.net.codec.status.server.CodecStatusResponse;
import com.captainbern.minecraft.net.packet.status.client.PacketPing;
import com.captainbern.minecraft.net.packet.status.client.PacketStatusRequest;
import com.captainbern.minecraft.net.packet.status.server.PacketStatusResponse;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.ProtocolState;
import com.captainbern.minecraft.net.protocol.Side;

class StatusProtocol extends MinecraftProtocol {

    public StatusProtocol() {
        super(ProtocolState.STATUS);

        registerClient(0x0, PacketStatusRequest.class, CodecStatusRequest.class);
        registerClient(0x1, PacketPing.class, CodecPing.class);

        registerServer(0x0, PacketStatusResponse.class, CodecStatusResponse.class);
        registerServer(0x1, com.captainbern.minecraft.net.packet.status.server.PacketPing.class, com.captainbern.minecraft.net.codec.status.server.CodecPing.class);
    }
}
