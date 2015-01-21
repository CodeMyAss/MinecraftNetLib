package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketKeepAlive;
import com.captainbern.litebot.net.utils.ByteBufUtils;
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
