package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketDigging;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecDigging implements Codec<PacketDigging> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketDigging packet) {
        byteBuf.writeByte(packet.getStatus());
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeByte(packet.getFace());

        return byteBuf;
    }

    @Override
    public PacketDigging decode(ByteBuf byteBuf) {
        byte status = byteBuf.readByte();
        BlockVector location = ByteBufUtils.readBlockPosition(byteBuf);
        byte face = byteBuf.readByte();

        return new PacketDigging(status, location.getX(), location.getY(), location.getZ(), face);
    }
}
