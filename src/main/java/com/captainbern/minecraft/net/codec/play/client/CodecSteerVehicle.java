package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketSteerVehicle;
import io.netty.buffer.ByteBuf;

public class CodecSteerVehicle implements Codec<PacketSteerVehicle> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketSteerVehicle packet) {
        byteBuf.writeFloat(packet.getSideways());
        byteBuf.writeFloat(packet.getForward());
        byteBuf.writeByte((packet.isJump() ? 1 : 0) | (packet.isUnmount() ? 2 : 0));

        return byteBuf;
    }

    @Override
    public PacketSteerVehicle decode(ByteBuf byteBuf) {
        float sideWays = byteBuf.readFloat();
        float forward = byteBuf.readFloat();
        int flags = byteBuf.readUnsignedByte();

        boolean isjump = (flags & 0x1) != 0;
        boolean isUnmount = (flags & 0x2) != 0;

        return new PacketSteerVehicle(sideWays, forward, isjump, isUnmount);
    }
}
