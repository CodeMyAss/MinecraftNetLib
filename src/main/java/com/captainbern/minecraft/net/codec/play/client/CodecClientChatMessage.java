package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketClientChatMessage;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecClientChatMessage implements Codec<PacketClientChatMessage> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketClientChatMessage packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getMessage());
        return byteBuf;
    }

    @Override
    public PacketClientChatMessage decode(ByteBuf byteBuf) {
        String text = ByteBufUtils.readUTF(byteBuf);
        return new PacketClientChatMessage(text);
    }
}
