package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketUpdateHealth;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecUpdateHealth implements Codec<PacketUpdateHealth> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateHealth packet) {
        byteBuf.writeFloat(packet.getHealth());
        ByteBufUtils.writeVarInt(byteBuf, packet.getFood());
        byteBuf.writeFloat(packet.getFoodSaturation());
        
        return byteBuf;
    }

    public PacketUpdateHealth decode(ByteBuf byteBuf) {
        float health = byteBuf.readFloat();
        int food = ByteBufUtils.readVarInt(byteBuf);
        float foodSaturation = byteBuf.readFloat();
        
        return new PacketUpdateHealth(health, food, foodSaturation);
    }
}
