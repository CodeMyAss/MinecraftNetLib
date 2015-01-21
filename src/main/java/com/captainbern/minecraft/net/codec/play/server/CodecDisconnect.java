package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketDisconnect;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.litebot.util.chat.Message;
import io.netty.buffer.ByteBuf;

public class CodecDisconnect implements Codec<PacketDisconnect> {

    public ByteBuf encode(ByteBuf byteBuf, PacketDisconnect packet) {
        ByteBufUtils.writeMessage(byteBuf, packet.getMessage());

        return byteBuf;
    }

    public PacketDisconnect decode(ByteBuf byteBuf) {
        Message message = ByteBufUtils.readMessage(byteBuf);

        return new PacketDisconnect(message);
    }
}
