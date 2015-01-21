package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketServerDifficulty;
import io.netty.buffer.ByteBuf;

public class CodecServerDifficulty implements Codec<PacketServerDifficulty> {

    public ByteBuf encode(ByteBuf byteBuf, PacketServerDifficulty packet) {
        byteBuf.writeByte(packet.getDifficulty());

        return byteBuf;
    }

    public PacketServerDifficulty decode(ByteBuf byteBuf) {
        int difficulty = byteBuf.readUnsignedByte();

        return new PacketServerDifficulty(difficulty);
    }
}
