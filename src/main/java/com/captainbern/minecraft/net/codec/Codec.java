package com.captainbern.minecraft.net.codec;

import com.captainbern.minecraft.net.packet.Packet;
import io.netty.buffer.ByteBuf;

public interface Codec<T extends Packet> {

    public ByteBuf encode(ByteBuf byteBuf, T packet);

    public T decode(ByteBuf byteBuf);
}
