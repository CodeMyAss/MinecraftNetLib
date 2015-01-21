package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketPluginMessage;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecPluginMessage implements Codec<PacketPluginMessage> {

    public ByteBuf encode(ByteBuf byteBuf, PacketPluginMessage packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getChannel());
        byteBuf.writeBytes(packet.getData());

        return byteBuf;
    }

    public PacketPluginMessage decode(ByteBuf byteBuf) {
        String channel = ByteBufUtils.readUTF(byteBuf);
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        return new PacketPluginMessage(channel, data);
    }
}
