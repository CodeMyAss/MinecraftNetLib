package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketAnimation;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecAnimation implements Codec<PacketAnimation> {

    public ByteBuf encode(ByteBuf byteBuf, PacketAnimation packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getAnimation());

        return byteBuf;
    }

    public PacketAnimation decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        int animationid = byteBuf.readUnsignedByte();

        return new PacketAnimation(entityId, animationid);
    }
}
