package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketResourcePackStatus;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecResourcePackStatus implements Codec<PacketResourcePackStatus> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketResourcePackStatus packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getHash());
        ByteBufUtils.writeVarInt(byteBuf, packet.getStatus());

        return byteBuf;
    }

    @Override
    public PacketResourcePackStatus decode(ByteBuf byteBuf) {
        String hash = ByteBufUtils.readUTF(byteBuf);
        int status = ByteBufUtils.readVarInt(byteBuf);

        return new PacketResourcePackStatus(hash, status);
    }
}
