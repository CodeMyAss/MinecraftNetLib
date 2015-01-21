package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketWindowItems;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class CodecWindowItems implements Codec<PacketWindowItems> {

    public ByteBuf encode(ByteBuf byteBuf, PacketWindowItems packet) {
        byteBuf.writeByte(packet.getWindowId());

        byteBuf.writeShort(packet.getItems().size());
        for (ItemStack itemStack : packet.getItems()) {
            ByteBufUtils.writeSlot(byteBuf, itemStack);
        }

        return byteBuf;
    }

    public PacketWindowItems decode(ByteBuf byteBuf) {
        int windowId = byteBuf.readUnsignedByte();

        short itemCount = byteBuf.readShort();
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            ItemStack itemStack = ByteBufUtils.readSlot(byteBuf);
            items.add(itemStack);
        }

        return new PacketWindowItems(windowId, items);
    }
}
