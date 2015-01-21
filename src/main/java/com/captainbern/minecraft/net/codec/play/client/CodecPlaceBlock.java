package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketPlaceBlock;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecPlaceBlock implements Codec<PacketPlaceBlock> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlaceBlock packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeByte(packet.getDirection());
        ByteBufUtils.writeSlot(byteBuf, packet.getItem());
        byteBuf.writeByte(packet.getCursorX());
        byteBuf.writeByte(packet.getCursorY());
        byteBuf.writeByte(packet.getCursorZ());

        return byteBuf;
    }

    @Override
    public PacketPlaceBlock decode(ByteBuf byteBuf) {
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        byte direction = byteBuf.readByte();
        ItemStack item = ByteBufUtils.readSlot(byteBuf);
        byte cursorX = byteBuf.readByte();
        byte cursorY = byteBuf.readByte();
        byte cursorZ = byteBuf.readByte();

        return new PacketPlaceBlock(blockVector.getX(), blockVector.getY(), blockVector.getZ(), direction, item, cursorX, cursorY, cursorZ);
    }
}
