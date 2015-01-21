package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketKeepAlive;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecKeepAlive implements Codec<PacketKeepAlive> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketKeepAlive packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getKeepAliveId());
        return byteBuf;
    }

    @Override
    public PacketKeepAlive decode(ByteBuf byteBuf) {
        return new PacketKeepAlive(ByteBufUtils.readVarInt(byteBuf));
    }
}
