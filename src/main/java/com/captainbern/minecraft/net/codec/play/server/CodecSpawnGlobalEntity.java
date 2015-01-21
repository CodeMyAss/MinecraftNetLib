package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnGlobalEntity;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSpawnGlobalEntity implements Codec<PacketSpawnGlobalEntity> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnGlobalEntity packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getType());
        ByteBufUtils.writeVarInt(byteBuf, packet.getX());
        ByteBufUtils.writeVarInt(byteBuf, packet.getY());
        ByteBufUtils.writeVarInt(byteBuf, packet.getZ());
        
        return byteBuf;
    }

    public PacketSpawnGlobalEntity decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte type = byteBuf.readByte();
        int x = ByteBufUtils.readVarInt(byteBuf);
        int y = ByteBufUtils.readVarInt(byteBuf);
        int z = ByteBufUtils.readVarInt(byteBuf);
        
        return new PacketSpawnGlobalEntity(entityId, type, x, y, z);
    }
}
