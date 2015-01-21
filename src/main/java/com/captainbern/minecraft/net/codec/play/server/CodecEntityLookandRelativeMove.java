package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityLookAndRelativeMove;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityLookandRelativeMove implements Codec<PacketEntityLookAndRelativeMove> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityLookAndRelativeMove packet) {
        ByteBufUtils.writeVarInt(byteBuf,packet.getEntityId());
        byteBuf.writeByte(packet.getX());
        byteBuf.writeByte(packet.getY());
        byteBuf.writeByte(packet.getZ());
        byteBuf.writeByte(packet.getYaw());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeBoolean(packet.isOnGround());
        
        return byteBuf;
    }

    public PacketEntityLookAndRelativeMove decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte dX = byteBuf.readByte();
        byte dY = byteBuf.readByte();
        byte dZ = byteBuf.readByte();
        byte yaw = byteBuf.readByte();
        byte pitch = byteBuf.readByte();
        boolean onGround = byteBuf.readBoolean();
        
        return new PacketEntityLookAndRelativeMove(entityId, dX, dY, dZ, yaw, pitch, onGround);
    }
}
