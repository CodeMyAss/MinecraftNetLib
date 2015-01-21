package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketChangeGameState;
import io.netty.buffer.ByteBuf;

public class CodecChangeGameState implements Codec<PacketChangeGameState> {

    public ByteBuf encode(ByteBuf byteBuf, PacketChangeGameState packet) {
        byteBuf.writeByte(packet.getReason());
        byteBuf.writeFloat(packet.getValue());

        return byteBuf;
    }

    public PacketChangeGameState decode(ByteBuf byteBuf) {
        int reason = byteBuf.readByte();
        float value = byteBuf.readFloat();

        return new PacketChangeGameState(reason, value);
    }
}
