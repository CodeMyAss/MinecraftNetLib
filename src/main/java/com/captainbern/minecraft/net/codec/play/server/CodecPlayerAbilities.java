package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketPlayerAbilities;
import io.netty.buffer.ByteBuf;

public class CodecPlayerAbilities implements Codec<PacketPlayerAbilities> {

    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerAbilities packet) {
        byteBuf.writeByte(packet.getFlags());
        byteBuf.writeFloat(packet.getFlyingSpeed());
        byteBuf.writeFloat(packet.getWalkSpeed());

        return byteBuf;
    }

    public PacketPlayerAbilities decode(ByteBuf byteBuf) {
        int flags = byteBuf.readUnsignedByte();
        float flyingSpeed = byteBuf.readFloat();
        float walkSpeed = byteBuf.readFloat();

        return new PacketPlayerAbilities(flags, flyingSpeed, walkSpeed);
    }
}
