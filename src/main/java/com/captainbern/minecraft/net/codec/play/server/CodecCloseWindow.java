package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketCloseWindow;
import io.netty.buffer.ByteBuf;

public class CodecCloseWindow implements Codec<PacketCloseWindow> {

    public ByteBuf encode(ByteBuf byteBuf, PacketCloseWindow packet) {
        byteBuf.writeByte(packet.getWindowId());

        return byteBuf;
    }

    public PacketCloseWindow decode(ByteBuf byteBuf) {
        int windowId = byteBuf.readUnsignedByte();

        return new PacketCloseWindow(windowId);
    }
}
