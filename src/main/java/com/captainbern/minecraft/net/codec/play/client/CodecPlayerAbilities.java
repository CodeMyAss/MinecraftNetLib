package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerAbilities;
import io.netty.buffer.ByteBuf;

public class CodecPlayerAbilities implements Codec<PacketPlayerAbilities> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerAbilities packet) {
        byteBuf.writeByte(packet.getFlags());
        byteBuf.writeFloat(packet.getFlySpeed());
        byteBuf.writeFloat(packet.getWalkSpeed());

        return byteBuf;
    }

    @Override
    public PacketPlayerAbilities decode(ByteBuf byteBuf) {
        byte flags = byteBuf.readByte();
        float flySpeed = byteBuf.readFloat();
        float walkSpeed = byteBuf.readFloat();

        return new PacketPlayerAbilities(flags, flySpeed, walkSpeed);
    }
}
