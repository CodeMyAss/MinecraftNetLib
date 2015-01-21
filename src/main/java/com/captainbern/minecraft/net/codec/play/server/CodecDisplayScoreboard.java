package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketDisplayScoreboard;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecDisplayScoreboard implements Codec<PacketDisplayScoreboard> {

    public ByteBuf encode(ByteBuf byteBuf, PacketDisplayScoreboard packet) {
        byteBuf.writeByte(packet.getPosition());
        ByteBufUtils.writeUTF(byteBuf, packet.getMessage());

        return byteBuf;
    }

    public PacketDisplayScoreboard decode(ByteBuf byteBuf) {
        int position = byteBuf.readByte();
        String message = ByteBufUtils.readUTF(byteBuf);

        return new PacketDisplayScoreboard(position, message);
    }
}
