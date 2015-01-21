package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketEnchantItem;
import io.netty.buffer.ByteBuf;

public class CodecEnchantItem implements Codec<PacketEnchantItem> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketEnchantItem packet) {
        return null;
    }

    @Override
    public PacketEnchantItem decode(ByteBuf byteBuf) {
        return null;
    }
}
