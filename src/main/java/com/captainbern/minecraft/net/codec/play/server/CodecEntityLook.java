package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityLook;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityLook implements Codec<PacketEntityLook> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityLook packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getYaw());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeBoolean(packet.isOnGround());
        
        return byteBuf;
    }

    public PacketEntityLook decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte yaw = byteBuf.readByte();
        byte pitch = byteBuf.readByte();
        boolean onGround = byteBuf.readBoolean();
        
        return new PacketEntityLook(entityId, yaw, pitch, onGround);
    }
}
