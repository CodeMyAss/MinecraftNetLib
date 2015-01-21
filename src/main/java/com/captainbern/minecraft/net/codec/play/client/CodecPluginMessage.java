package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketPluginMessage;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecPluginMessage implements Codec<PacketPluginMessage> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPluginMessage packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getChannel());
        byteBuf.writeBytes(packet.getData());

        return byteBuf;
    }

    @Override
    public PacketPluginMessage decode(ByteBuf byteBuf) {
        String channel = ByteBufUtils.readUTF(byteBuf);
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        return new PacketPluginMessage(channel, data);
    }
}
