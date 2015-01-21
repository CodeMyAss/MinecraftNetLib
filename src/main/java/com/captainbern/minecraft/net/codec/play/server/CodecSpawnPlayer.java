package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnPlayer;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.UUID;

public class CodecSpawnPlayer implements Codec<PacketSpawnPlayer> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnPlayer packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeUuid(byteBuf, packet.getPlayerUuid());
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeInt(packet.getZ());
        byteBuf.writeByte(packet.getYaw());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeShort(packet.getItem());
        ByteBufUtils.writeMetadata(byteBuf, packet.getMetadata());

        return byteBuf;
    }

    public PacketSpawnPlayer decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        UUID playerUuid = ByteBufUtils.readUuid(byteBuf);
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        int z = byteBuf.readInt();
        byte yaw = byteBuf.readByte();
        byte pitch = byteBuf.readByte();
        short item = byteBuf.readShort();
        List<Metadata> metadata = ByteBufUtils.readMetadata(byteBuf);

        return new PacketSpawnPlayer(entityId, playerUuid, x, y, z, yaw, pitch, item, metadata);
    }
}
