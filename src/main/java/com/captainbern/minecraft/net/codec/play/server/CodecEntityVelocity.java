package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityVelocity;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityVelocity implements Codec<PacketEntityVelocity> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityVelocity packet) {
        ByteBufUtils.writeVarInt(byteBuf,packet.getEntityId());
        byteBuf.writeShort(packet.getVelocityX());
        byteBuf.writeShort(packet.getVelocityY());
        byteBuf.writeShort(packet.getVelocityZ());
        
        return byteBuf;
    }

    public PacketEntityVelocity decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        short x = byteBuf.readShort();
        short y = byteBuf.readShort();
        short z = byteBuf.readShort();

        return new PacketEntityVelocity(entityId, x, y, z);
    }
}
