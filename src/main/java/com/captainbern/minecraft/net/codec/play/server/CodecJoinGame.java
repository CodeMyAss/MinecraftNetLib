package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketJoinGame;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecJoinGame implements Codec<PacketJoinGame> {

    public ByteBuf encode(ByteBuf byteBuf, PacketJoinGame packet) {
        byteBuf.writeInt(packet.getEntityId());
        byteBuf.writeByte(packet.getGameMode());
        byteBuf.writeByte(packet.getDimension());
        byteBuf.writeByte(packet.getDifficulty());
        byteBuf.writeByte(packet.getMaxPlayers());
        ByteBufUtils.writeUTF(byteBuf, packet.getLevelType());
        byteBuf.writeBoolean(packet.isReducedDebugInfo());

        return byteBuf;
    }

    public PacketJoinGame decode(ByteBuf byteBuf) {
        int entityId = byteBuf.readInt();
        int gameMode = byteBuf.readUnsignedByte();
        int dimension = byteBuf.readByte();
        int difficulty = byteBuf.readUnsignedByte();
        int maxPlayers = byteBuf.readUnsignedByte();
        String levelType = ByteBufUtils.readUTF(byteBuf);
        boolean reducedDebugInfo = byteBuf.readBoolean();

        return new PacketJoinGame(entityId, gameMode, dimension, difficulty, maxPlayers, levelType, reducedDebugInfo);
    }
}
