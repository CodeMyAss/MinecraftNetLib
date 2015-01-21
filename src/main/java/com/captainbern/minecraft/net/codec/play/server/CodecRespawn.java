package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketRespawn;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecRespawn implements Codec<PacketRespawn> {

    public ByteBuf encode(ByteBuf byteBuf, PacketRespawn packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getDimension());
        byteBuf.writeByte(packet.getDifficulty());
        byteBuf.writeByte(packet.getGameMode());
        ByteBufUtils.writeUTF(byteBuf, packet.getLevelType());
        
        return byteBuf;
    }

    public PacketRespawn decode(ByteBuf byteBuf) {
        int dimension = ByteBufUtils.readVarInt(byteBuf);
        byte difficulty = byteBuf.readByte();
        byte gameMode = byteBuf.readByte();
        String levelType = ByteBufUtils.readUTF(byteBuf);
        
        return new PacketRespawn(dimension, difficulty, gameMode, levelType);
    }
}
