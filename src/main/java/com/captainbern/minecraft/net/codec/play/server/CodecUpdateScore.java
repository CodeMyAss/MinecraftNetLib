package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketUpdateScore;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecUpdateScore implements Codec<PacketUpdateScore> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateScore packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getScoreName());
        byteBuf.writeByte(packet.getAction());
        ByteBufUtils.writeUTF(byteBuf, packet.getObjectiveName());
        ByteBufUtils.writeVarInt(byteBuf, packet.getValue());
        
        return byteBuf;
    }

    public PacketUpdateScore decode(ByteBuf byteBuf) {
        String scoreName = ByteBufUtils.readUTF(byteBuf);
        byte action = byteBuf.readByte();
        String objectiveName = ByteBufUtils.readUTF(byteBuf);
        int value = ByteBufUtils.readVarInt(byteBuf);
        
        return new PacketUpdateScore(scoreName, action, objectiveName, value);
    }
}
