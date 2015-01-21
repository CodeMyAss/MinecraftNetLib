package com.captainbern.minecraft.net.codec.login.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginResponse;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecLoginResponse implements Codec<PacketLoginResponse> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketLoginResponse packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getUuid());
        ByteBufUtils.writeUTF(byteBuf, packet.getUsername());
        return byteBuf;
    }

    @Override
    public PacketLoginResponse decode(ByteBuf byteBuf) {
        String uuid = ByteBufUtils.readUTF(byteBuf);
        String username = ByteBufUtils.readUTF(byteBuf);
        return new PacketLoginResponse(uuid, username);
    }
}
