package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSetCompression;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSetCompression implements Codec<PacketSetCompression> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSetCompression packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getThreshold());

        return byteBuf;
    }

    public PacketSetCompression decode(ByteBuf byteBuf) {
        int threshold = ByteBufUtils.readVarInt(byteBuf);

        return new PacketSetCompression(threshold);
    }
}
