package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketPlayerUpdatePositionAndLook;
import io.netty.buffer.ByteBuf;

public class CodecPlayerUpdatePositionLook implements Codec<PacketPlayerUpdatePositionAndLook> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerUpdatePositionAndLook packet) {
        byteBuf.writeDouble(packet.getX());
        byteBuf.writeDouble(packet.getFeetY());
        byteBuf.writeDouble(packet.getZ());
        byteBuf.writeFloat(packet.getYaw());
        byteBuf.writeFloat(packet.getPitch());
        byteBuf.writeBoolean(packet.isOnGround());

        return byteBuf;
    }

    @Override
    public PacketPlayerUpdatePositionAndLook decode(ByteBuf byteBuf) {
        double x = byteBuf.readDouble();
        double y = byteBuf.readDouble();
        double z = byteBuf.readDouble();
        float yaw = byteBuf.readFloat();
        float pitch = byteBuf.readFloat();
        boolean onGround = byteBuf.readBoolean();

        return new PacketPlayerUpdatePositionAndLook(x, y, z, yaw, pitch, onGround);
    }
}
