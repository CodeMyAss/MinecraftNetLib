package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketHeldItemChange;
import io.netty.buffer.ByteBuf;

public class CodecHeldItemChange implements Codec<PacketHeldItemChange> {

    public ByteBuf encode(ByteBuf byteBuf, PacketHeldItemChange packet) {
        byteBuf.writeByte(packet.getSlot());

        return byteBuf;
    }

    public PacketHeldItemChange decode(ByteBuf byteBuf) {
        short slot = byteBuf.readByte();

        return new PacketHeldItemChange(slot);
    }
}
