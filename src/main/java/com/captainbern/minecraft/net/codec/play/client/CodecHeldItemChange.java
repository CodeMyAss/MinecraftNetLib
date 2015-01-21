package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketHeldItemChange;
import io.netty.buffer.ByteBuf;

public class CodecHeldItemChange implements Codec<PacketHeldItemChange> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketHeldItemChange packet) {
        byteBuf.writeShort(packet.getSlot());

        return byteBuf;
    }

    @Override
    public PacketHeldItemChange decode(ByteBuf byteBuf) {
        short slot = byteBuf.readShort();
        return new PacketHeldItemChange(slot);
    }
}
