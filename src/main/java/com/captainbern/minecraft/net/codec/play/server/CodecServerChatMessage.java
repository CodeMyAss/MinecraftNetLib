package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketServerChatMessage;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.chat.Message;
import io.netty.buffer.ByteBuf;

public class CodecServerChatMessage implements Codec<PacketServerChatMessage> {

    public ByteBuf encode(ByteBuf byteBuf, PacketServerChatMessage packet) {
        ByteBufUtils.writeMessage(byteBuf, packet.getMessage());
        byteBuf.writeByte(packet.getPosition());

        return byteBuf;
    }

    public PacketServerChatMessage decode(ByteBuf byteBuf) {
        Message message = ByteBufUtils.readMessage(byteBuf);
        byte position = byteBuf.readByte();

        return new PacketServerChatMessage(message, position);
    }
}
