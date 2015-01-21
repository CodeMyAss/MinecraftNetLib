package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnMob;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.List;

public class CodecSpawnMob implements Codec<PacketSpawnMob> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnMob packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getType());
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeInt(packet.getZ());
        byteBuf.writeByte(packet.getYaw());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeByte(packet.getHeadPitch());
        byteBuf.writeShort(packet.getVelocityX());
        byteBuf.writeShort(packet.getVelocityY());
        byteBuf.writeShort(packet.getVelocityZ());
        ByteBufUtils.writeMetadata(byteBuf, packet.getMetadata());

        return byteBuf;
    }

    public PacketSpawnMob decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        short type = byteBuf.readUnsignedByte();
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        int z = byteBuf.readInt();
        byte yaw = byteBuf.readByte();
        byte pitch = byteBuf.readByte();
        byte headPitch = byteBuf.readByte();
        short velocityX = byteBuf.readShort();
        short velocityY = byteBuf.readShort();
        short velocityZ = byteBuf.readShort();
        List<Metadata> metadata = ByteBufUtils.readMetadata(byteBuf);

        return new PacketSpawnMob(entityId, type, x, y, z, yaw, pitch, headPitch, velocityX, velocityY, velocityZ, metadata);
    }
}
