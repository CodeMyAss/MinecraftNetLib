package com.captainbern.minecraft.net.codec.handshake.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.handshake.client.PacketHandshake;
import com.captainbern.minecraft.net.protocol.ProtocolState;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecHandshake implements Codec<PacketHandshake> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketHandshake packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getProtocolVersion());
        ByteBufUtils.writeUTF(byteBuf, packet.getServerAddress());
        byteBuf.writeShort(packet.getServerPort());
        ByteBufUtils.writeVarInt(byteBuf, packet.getNextState().getId());
        return byteBuf;
    }

    @Override
    public PacketHandshake decode(ByteBuf byteBuf) {
        int protocolVersion = ByteBufUtils.readVarInt(byteBuf);
        String serverAddress = ByteBufUtils.readUTF(byteBuf);
        int port = byteBuf.readUnsignedShort();
        int nextState = ByteBufUtils.readVarInt(byteBuf);

        return new PacketHandshake(protocolVersion, serverAddress, port, ProtocolState.getById(nextState));
    }
}
