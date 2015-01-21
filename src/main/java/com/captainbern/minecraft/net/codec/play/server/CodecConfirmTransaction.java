package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketConfirmTransaction;
import io.netty.buffer.ByteBuf;

public class CodecConfirmTransaction implements Codec<PacketConfirmTransaction> {

    public ByteBuf encode(ByteBuf byteBuf, PacketConfirmTransaction packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeShort(packet.getAction());
        byteBuf.writeBoolean(packet.isAccepted());

        return byteBuf;
    }

    public PacketConfirmTransaction decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        short action = byteBuf.readShort();
        boolean accepted = byteBuf.readBoolean();

        return new PacketConfirmTransaction(windowId, action, accepted);
    }
}
