package com.captainbern.minecraft.net.codec.login.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginKickDisconnect;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecLoginKickDisconnect implements Codec<PacketLoginKickDisconnect> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketLoginKickDisconnect packet) {
        ByteBufUtils.writeMessage(byteBuf, packet.getMessage());

        return byteBuf;
    }

    @Override
    public PacketLoginKickDisconnect decode(ByteBuf byteBuf) {
        Message message = ByteBufUtils.readMessage(byteBuf);

        return new PacketLoginKickDisconnect(message);
    }
}
