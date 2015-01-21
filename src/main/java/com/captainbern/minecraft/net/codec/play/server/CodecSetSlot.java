package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSetSlot;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSetSlot implements Codec<PacketSetSlot> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSetSlot packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeShort(packet.getSlot());
        ByteBufUtils.writeSlot(byteBuf, packet.getItemStack());

        return byteBuf;
    }

    public PacketSetSlot decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        short slot = byteBuf.readShort();
        ItemStack itemStack = ByteBufUtils.readSlot(byteBuf);

        return new PacketSetSlot(windowId, slot, itemStack);
    }
}
