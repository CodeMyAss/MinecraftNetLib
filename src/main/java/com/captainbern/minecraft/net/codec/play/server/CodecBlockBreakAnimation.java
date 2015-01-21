package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockBreakAnimation;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecBlockBreakAnimation implements Codec<PacketBlockBreakAnimation> {

    public ByteBuf encode(ByteBuf byteBuf, PacketBlockBreakAnimation packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeByte(packet.getStage());

        return byteBuf;
    }

    public PacketBlockBreakAnimation decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        byte stage = byteBuf.readByte();

        return new PacketBlockBreakAnimation(entityId, blockVector.getX(), blockVector.getY(), blockVector.getZ(), stage);
    }
}
