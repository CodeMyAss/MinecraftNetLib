package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerUpdate;
import io.netty.buffer.ByteBuf;

public class CodecPlayerUpdate implements Codec<PacketPlayerUpdate> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerUpdate packet) {
        byteBuf.writeBoolean(packet.isOnGround());
        return byteBuf;
    }

    @Override
    public PacketPlayerUpdate decode(ByteBuf byteBuf) {
        boolean onGround = byteBuf.readBoolean();
        return new PacketPlayerUpdate(onGround);
    }
}
