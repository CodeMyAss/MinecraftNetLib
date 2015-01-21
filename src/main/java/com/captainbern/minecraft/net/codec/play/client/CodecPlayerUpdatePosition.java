package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketPlayerUpdatePosition;
import io.netty.buffer.ByteBuf;

public class CodecPlayerUpdatePosition implements Codec<PacketPlayerUpdatePosition> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerUpdatePosition packet) {
        byteBuf.writeDouble(packet.getX());
        byteBuf.writeDouble(packet.getFeetY());
        byteBuf.writeDouble(packet.getZ());
        byteBuf.writeBoolean(packet.isOnGround());

        return byteBuf;
    }

    @Override
    public PacketPlayerUpdatePosition decode(ByteBuf byteBuf) {
        double x = byteBuf.readDouble();
        double y = byteBuf.readDouble();
        double z = byteBuf.readDouble();
        boolean onGround = byteBuf.readBoolean();

        return new PacketPlayerUpdatePosition(x, y, z, onGround);
    }
}
