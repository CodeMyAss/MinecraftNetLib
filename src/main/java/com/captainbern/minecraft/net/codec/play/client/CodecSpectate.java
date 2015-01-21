package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketSpectate;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class CodecSpectate implements Codec<PacketSpectate> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketSpectate packet) {
        ByteBufUtils.writeUuid(byteBuf, packet.getTargetPlayer());
        return byteBuf;
    }

    @Override
    public PacketSpectate decode(ByteBuf byteBuf) {
        UUID uuid = ByteBufUtils.readUuid(byteBuf);
        return new PacketSpectate(uuid);
    }
}
