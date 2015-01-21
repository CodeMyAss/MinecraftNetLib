package com.captainbern.minecraft.net.codec.login.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.client.PacketLoginRequest;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecLoginRequest implements Codec<PacketLoginRequest> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketLoginRequest packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getName());
        return byteBuf;
    }

    @Override
    public PacketLoginRequest decode(ByteBuf byteBuf) {
        return new PacketLoginRequest(ByteBufUtils.readUTF(byteBuf));
    }
}
