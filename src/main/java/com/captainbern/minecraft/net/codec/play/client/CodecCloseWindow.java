package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketCloseWindow;
import io.netty.buffer.ByteBuf;

public class CodecCloseWindow implements Codec<PacketCloseWindow> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketCloseWindow packet) {
        byteBuf.writeByte(packet.getWindowId());

        return byteBuf;
    }

    @Override
    public PacketCloseWindow decode(ByteBuf byteBuf) {
        byte windowId = (byte) byteBuf.readUnsignedByte();

        return new PacketCloseWindow(windowId);
    }
}
