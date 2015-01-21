package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityStatus;
import io.netty.buffer.ByteBuf;

public class CodecEntityStatus implements Codec<PacketEntityStatus> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityStatus packet) {
        byteBuf.writeInt(packet.getEntityId());
        byteBuf.writeByte(packet.getEntityStatus());
        
        return byteBuf;
    }

    public PacketEntityStatus decode(ByteBuf byteBuf) {
        int entityId = byteBuf.readInt();
        int entityStatus = byteBuf.readByte();
        
        return new PacketEntityStatus(entityId, entityStatus);
    }
}
