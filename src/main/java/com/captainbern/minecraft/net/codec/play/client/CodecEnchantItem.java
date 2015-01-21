package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketEnchantItem;
import io.netty.buffer.ByteBuf;

public class CodecEnchantItem implements Codec<PacketEnchantItem> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketEnchantItem packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeByte(packet.getEnchantment());

        return byteBuf;
    }

    @Override
    public PacketEnchantItem decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        byte enchantment = byteBuf.readByte();

        return new PacketEnchantItem(windowId, enchantment);
    }
}
