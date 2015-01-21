package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketChunkData;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecChunkData implements Codec<PacketChunkData> {

    public ByteBuf encode(ByteBuf byteBuf, PacketChunkData packet) {
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getZ());
        byteBuf.writeBoolean(packet.isContinuous());
        byteBuf.writeShort(packet.getBitmask());
        ByteBufUtils.writeVarInt(byteBuf, packet.getData().length);
        byteBuf.writeBytes(packet.getData());

        return byteBuf;
    }

    public PacketChunkData decode(ByteBuf byteBuf) {
        int x = byteBuf.readInt();
        int z = byteBuf.readInt();
        boolean continuous = byteBuf.readBoolean();
        int bitmask = byteBuf.readUnsignedShort();
        byte[] data = new byte[ByteBufUtils.readVarInt(byteBuf)];
        byteBuf.readBytes(data);

        return new PacketChunkData(x, z, continuous, bitmask, data);
    }
}
