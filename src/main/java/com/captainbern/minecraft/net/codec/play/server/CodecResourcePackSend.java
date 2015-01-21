package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketResourcePackSend;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecResourcePackSend implements Codec<PacketResourcePackSend> {

    public ByteBuf encode(ByteBuf byteBuf, PacketResourcePackSend packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getUrl());
        ByteBufUtils.writeUTF(byteBuf, packet.getHash());

        return byteBuf;
    }

    public PacketResourcePackSend decode(ByteBuf byteBuf) {
        String url = ByteBufUtils.readUTF(byteBuf);
        String hash = ByteBufUtils.readUTF(byteBuf);

        return new PacketResourcePackSend(url ,hash);
    }
}
