package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketWindowProperty;
import io.netty.buffer.ByteBuf;

public class CodecWindowProperty implements Codec<PacketWindowProperty> {

    public ByteBuf encode(ByteBuf byteBuf, PacketWindowProperty packet) {
        byteBuf.writeByte(packet.getWindowId());
        byteBuf.writeShort(packet.getProperty());
        byteBuf.writeShort(packet.getValue());
        
        return byteBuf;
    }

    public PacketWindowProperty decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        short property = byteBuf.readShort();
        short value = byteBuf.readShort();
        
        return new PacketWindowProperty(windowId, property, value);
    }
}
