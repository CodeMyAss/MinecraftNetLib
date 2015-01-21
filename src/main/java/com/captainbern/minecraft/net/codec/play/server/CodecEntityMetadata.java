package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityMetadata;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class CodecEntityMetadata implements Codec<PacketEntityMetadata> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityMetadata packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeMetadata(byteBuf, packet.getMetadata());

        return byteBuf;
    }

    public PacketEntityMetadata decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        List<Metadata> metadata = ByteBufUtils.readMetadata(byteBuf);

        return new PacketEntityMetadata(entityId, metadata);
    }
}
