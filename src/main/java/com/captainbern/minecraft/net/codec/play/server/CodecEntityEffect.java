package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityEffect;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityEffect implements Codec<PacketEntityEffect> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityEffect packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getEffectId());
        byteBuf.writeByte(packet.getAmplifier());
        ByteBufUtils.writeVarInt(byteBuf, packet.getDuration());
        byteBuf.writeBoolean(packet.isHideParticles());

        return byteBuf;
    }

    public PacketEntityEffect decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        int effectId = byteBuf.readByte();
        int amplifier = byteBuf.readByte();
        int duration = ByteBufUtils.readVarInt(byteBuf);
        boolean isHideParticles = byteBuf.readBoolean();

        return new PacketEntityEffect(entityId, effectId, amplifier, duration, isHideParticles);
    }
}
