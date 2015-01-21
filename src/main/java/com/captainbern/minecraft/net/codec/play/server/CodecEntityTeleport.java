package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityTeleport;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityTeleport implements Codec<PacketEntityTeleport> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityTeleport packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeInt(packet.getZ());
        byteBuf.writeByte(packet.getYaw());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeBoolean(packet.isOnGround());
        
        return byteBuf;
    }

    public PacketEntityTeleport decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        int z = byteBuf.readInt();
        byte yaw = byteBuf.readByte();
        byte pitch = byteBuf.readByte();
        boolean onGround = byteBuf.readBoolean();
        
        return new PacketEntityTeleport(entityId, x, y, z, yaw, pitch, onGround);
    }
}
