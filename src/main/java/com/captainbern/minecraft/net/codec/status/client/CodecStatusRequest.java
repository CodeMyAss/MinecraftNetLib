package com.captainbern.minecraft.net.codec.status.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.status.client.PacketStatusRequest;
import io.netty.buffer.ByteBuf;

public class CodecStatusRequest implements Codec<PacketStatusRequest> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketStatusRequest packet) {
        return byteBuf;
    }

    @Override
    public PacketStatusRequest decode(ByteBuf byteBuf) {
        return new PacketStatusRequest();
    }
}
