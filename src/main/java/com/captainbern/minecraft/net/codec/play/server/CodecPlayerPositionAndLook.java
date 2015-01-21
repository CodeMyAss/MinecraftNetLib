package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerPositionAndLook;
import io.netty.buffer.ByteBuf;

public class CodecPlayerPositionAndLook implements Codec<PacketPlayerPositionAndLook> {

    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerPositionAndLook packet) {
        byteBuf.writeDouble(packet.getX());
        byteBuf.writeDouble(packet.getY());
        byteBuf.writeDouble(packet.getZ());
        byteBuf.writeFloat(packet.getYaw());
        byteBuf.writeFloat(packet.getPitch());
        byteBuf.writeByte(packet.getFlags());
        
        return byteBuf;
    }

    public PacketPlayerPositionAndLook decode(ByteBuf byteBuf) {
        double x = byteBuf.readDouble();
        double y = byteBuf.readDouble();
        double z = byteBuf.readDouble();
        float yaw = byteBuf.readFloat();
        float pitch = byteBuf.readFloat();
        byte flags = byteBuf.readByte();
        
        return new PacketPlayerPositionAndLook(x, y, z, yaw, pitch, flags);
    }
}
