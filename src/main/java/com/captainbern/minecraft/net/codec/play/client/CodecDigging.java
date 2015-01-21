package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketDigging;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
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
