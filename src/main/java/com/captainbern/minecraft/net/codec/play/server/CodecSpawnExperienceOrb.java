package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSpawnExperienceOrb;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSpawnExperienceOrb implements Codec<PacketSpawnExperienceOrb> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnExperienceOrb packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeVarInt(byteBuf, packet.getX());
        ByteBufUtils.writeVarInt(byteBuf, packet.getY());
        ByteBufUtils.writeVarInt(byteBuf, packet.getZ());
        byteBuf.writeShort(packet.getCount());
        
        return byteBuf;
    }

    public PacketSpawnExperienceOrb decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        int x = ByteBufUtils.readVarInt(byteBuf);
        int y = ByteBufUtils.readVarInt(byteBuf);
        int z = ByteBufUtils.readVarInt(byteBuf);
        short count = byteBuf.readShort();
        
        return new PacketSpawnExperienceOrb(entityId, x, y, z, count);
    }
}
