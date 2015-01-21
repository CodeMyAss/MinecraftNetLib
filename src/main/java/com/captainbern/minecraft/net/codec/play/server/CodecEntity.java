package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEntity;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntity implements Codec<PacketEntity> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntity packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());

        return byteBuf;
    }

    public PacketEntity decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);

        return new PacketEntity(entityId);
    }
}
