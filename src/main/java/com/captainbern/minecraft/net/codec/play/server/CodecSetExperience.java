package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSetExperience;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSetExperience implements Codec<PacketSetExperience> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSetExperience packet) {
        byteBuf.writeFloat(packet.getExperienceBar());
        ByteBufUtils.writeVarInt(byteBuf, packet.getLevel());
        ByteBufUtils.writeVarInt(byteBuf, packet.getTotalExperience());
        
        return byteBuf;
    }

    public PacketSetExperience decode(ByteBuf byteBuf) {
        float experienceBar = byteBuf.readFloat();
        int level = ByteBufUtils.readVarInt(byteBuf);
        int totalExperience = ByteBufUtils.readVarInt(byteBuf);
        
        return new PacketSetExperience(experienceBar, level, totalExperience);
    }
}
