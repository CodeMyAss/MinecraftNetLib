package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityRelativeMove;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityRelativeMove implements Codec<PacketEntityRelativeMove> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityRelativeMove packet) {
        ByteBufUtils.writeVarInt(byteBuf,packet.getEntityId());
        byteBuf.writeByte(packet.getX());
        byteBuf.writeByte(packet.getY());
        byteBuf.writeByte(packet.getZ());
        byteBuf.writeBoolean(packet.isOnGround());
        
        return byteBuf;
    }

    public PacketEntityRelativeMove decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte dX = byteBuf.readByte();
        byte dY = byteBuf.readByte();
        byte dZ = byteBuf.readByte();
        boolean onGround = byteBuf.readBoolean();
        
        return new PacketEntityRelativeMove(entityId, dX, dY, dZ, onGround);
    }
}
