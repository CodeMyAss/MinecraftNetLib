package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntity;
import com.captainbern.litebot.net.utils.ByteBufUtils;
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
