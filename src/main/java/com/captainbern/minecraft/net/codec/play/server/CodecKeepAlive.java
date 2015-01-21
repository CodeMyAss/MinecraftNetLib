package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketKeepAlive;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecKeepAlive implements Codec<PacketKeepAlive> {

    public ByteBuf encode(ByteBuf byteBuf, PacketKeepAlive packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getKeepAliveId());

        return byteBuf;
    }

    public PacketKeepAlive decode(ByteBuf byteBuf) {
        int id = ByteBufUtils.readVarInt(byteBuf);

        return new PacketKeepAlive(id);
    }
}
