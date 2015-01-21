package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketClickWindow;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecClickWindow implements Codec<PacketClickWindow> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketClickWindow packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeShort(packet.getSlotId());
        byteBuf.writeByte(packet.getButton());
        byteBuf.writeShort(packet.getAction());
        byteBuf.writeByte(packet.getMode());
        ByteBufUtils.writeSlot(byteBuf, packet.getClickedItem());

        return byteBuf;
    }

    @Override
    public PacketClickWindow decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        short slotId = byteBuf.readShort();
        byte button = byteBuf.readByte();
        short action = byteBuf.readShort();
        byte mode = byteBuf.readByte();
        ItemStack clickedItem = ByteBufUtils.readSlot(byteBuf);

        return new PacketClickWindow(windowId, slotId, button, action, mode, clickedItem);
    }
}
