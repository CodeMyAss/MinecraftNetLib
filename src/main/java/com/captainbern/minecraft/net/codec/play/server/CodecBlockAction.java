package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockAction;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecBlockAction implements Codec<PacketBlockAction> {

    public ByteBuf encode(ByteBuf byteBuf, PacketBlockAction packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());

        byteBuf.writeByte(packet.getData1());
        byteBuf.writeByte(packet.getData2());

        ByteBufUtils.writeVarInt(byteBuf, packet.getBlockId());

        return byteBuf;
    }

    public PacketBlockAction decode(ByteBuf byteBuf) {
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);

        byte data1 = byteBuf.readByte();
        byte data2 = byteBuf.readByte();

        int blockId = ByteBufUtils.readVarInt(byteBuf);

        return new PacketBlockAction(blockVector.getX(), blockVector.getY(), blockVector.getZ(), data1, data2, blockId);
    }
}
