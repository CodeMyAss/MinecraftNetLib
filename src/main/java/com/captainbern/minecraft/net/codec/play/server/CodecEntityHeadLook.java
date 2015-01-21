package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityHeadLook;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityHeadLook implements Codec<PacketEntityHeadLook> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityHeadLook packet) {
        ByteBufUtils.writeVarInt(byteBuf,packet.getEntityId());
        byteBuf.writeByte(packet.getHeadYaw());
        
        return byteBuf;
    }

    public PacketEntityHeadLook decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte yaw = byteBuf.readByte();
        
        return new PacketEntityHeadLook(entityId, yaw);
    }
}
