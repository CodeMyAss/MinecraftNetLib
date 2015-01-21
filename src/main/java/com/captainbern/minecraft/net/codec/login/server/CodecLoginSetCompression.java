package com.captainbern.minecraft.net.codec.login.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginSetCompression;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecLoginSetCompression implements Codec<PacketLoginSetCompression> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketLoginSetCompression packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getThreshold());
        return byteBuf;
    }

    @Override
    public PacketLoginSetCompression decode(ByteBuf byteBuf) {
        int threshold = ByteBufUtils.readVarInt(byteBuf);
        return new PacketLoginSetCompression(threshold);
    }
}
