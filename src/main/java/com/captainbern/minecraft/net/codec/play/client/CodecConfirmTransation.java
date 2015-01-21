package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketConfirmTransation;
import io.netty.buffer.ByteBuf;

public class CodecConfirmTransation implements Codec<PacketConfirmTransation> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketConfirmTransation packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeShort(packet.getAction());
        byteBuf.writeBoolean(packet.isAccepted());

        return byteBuf;
    }

    @Override
    public PacketConfirmTransation decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        short action = byteBuf.readShort();
        boolean accepted = byteBuf.readBoolean();

        return new PacketConfirmTransation(windowId, action, accepted);
    }
}
