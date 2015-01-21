package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSetCompression;
import com.captainbern.litebot.net.utils.ByteBufUtils;
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
