package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.nbt.NbtTagCompound;
import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketUpdateBlockEntity;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecUpdateBlockEntity implements Codec<PacketUpdateBlockEntity> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateBlockEntity packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeByte(packet.getAction());
        ByteBufUtils.writeNbt(byteBuf, packet.getTagCompound());

        return byteBuf;
    }

    public PacketUpdateBlockEntity decode(ByteBuf byteBuf) {
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        byte action = byteBuf.readByte();
        NbtTagCompound tagCompound = ByteBufUtils.readNbt(byteBuf);

        return new PacketUpdateBlockEntity(blockVector.getX(), blockVector.getY(), blockVector.getZ(), action, tagCompound);
    }
}
