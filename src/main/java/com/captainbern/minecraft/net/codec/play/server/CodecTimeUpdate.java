package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketTimeUpdate;
import io.netty.buffer.ByteBuf;

public class CodecTimeUpdate implements Codec<PacketTimeUpdate> {

    public ByteBuf encode(ByteBuf byteBuf, PacketTimeUpdate packet) {
        byteBuf.writeLong(packet.getAgeOfWorld());
        byteBuf.writeLong(packet.getTimeOfDay());

        return byteBuf;
    }

    public PacketTimeUpdate decode(ByteBuf byteBuf) {
        long ageOfWorld = byteBuf.readLong();
        long timeOfDay = byteBuf.readLong();
        
        return new PacketTimeUpdate(ageOfWorld, timeOfDay);
    }
}
