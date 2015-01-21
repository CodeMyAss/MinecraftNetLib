package com.captainbern.minecraft.net.codec.status.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.status.server.PacketStatusResponse;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.buffer.ByteBuf;

public class CodecStatusResponse implements Codec<PacketStatusResponse> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketStatusResponse packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getJsonObject().getAsString());
        return byteBuf;
    }

    @Override
    public PacketStatusResponse decode(ByteBuf byteBuf) {
        return new PacketStatusResponse((JsonObject) new JsonParser().parse(ByteBufUtils.readUTF(byteBuf)));
    }
}
