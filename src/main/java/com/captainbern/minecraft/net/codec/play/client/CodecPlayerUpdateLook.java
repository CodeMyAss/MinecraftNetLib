package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketPlayerUpdateLook;
import io.netty.buffer.ByteBuf;

public class CodecPlayerUpdateLook implements Codec<PacketPlayerUpdateLook> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerUpdateLook packet) {
        byteBuf.writeFloat(packet.getYaw());
        byteBuf.writeFloat(packet.getPitch());
        byteBuf.writeBoolean(packet.isOnGround());

        return byteBuf;
    }

    @Override
    public PacketPlayerUpdateLook decode(ByteBuf byteBuf) {
        float yaw = byteBuf.readFloat();
        float picth = byteBuf.readFloat();
        boolean onGround = byteBuf.readBoolean();

        return new PacketPlayerUpdateLook(yaw, picth, onGround);
    }
}
