package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListHeaderFooter;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.chat.Message;
import io.netty.buffer.ByteBuf;

public class CodecPlayerListHeaderFooter implements Codec<PacketPlayerListHeaderFooter> {

    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerListHeaderFooter packet) {
        ByteBufUtils.writeMessage(byteBuf, packet.getHeader());
        ByteBufUtils.writeMessage(byteBuf, packet.getFooter());
        
        return byteBuf;
    }

    public PacketPlayerListHeaderFooter decode(ByteBuf byteBuf) {
        Message header = ByteBufUtils.readMessage(byteBuf);
        Message footer = ByteBufUtils.readMessage(byteBuf);
        
        return new PacketPlayerListHeaderFooter(header, footer);
    }
}
