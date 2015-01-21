package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSetSlot;
import com.captainbern.litebot.net.utils.ByteBufUtils;
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
