package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketSwingArm;
import io.netty.buffer.ByteBuf;

public class CodecSwingArm implements Codec<PacketSwingArm> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketSwingArm packet) {
        return byteBuf;
    }

    @Override
    public PacketSwingArm decode(ByteBuf byteBuf) {
        return new PacketSwingArm();
    }
}
