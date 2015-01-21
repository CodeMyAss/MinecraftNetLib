package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSoundEffect;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSoundEffect implements Codec<PacketSoundEffect> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSoundEffect packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getSoundName());
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeInt(packet.getZ());
        byteBuf.writeFloat(packet.getVolume());
        byteBuf.writeByte(packet.getPitch());
        
        return byteBuf;
    }

    public PacketSoundEffect decode(ByteBuf byteBuf) {
        String soundName = ByteBufUtils.readUTF(byteBuf);
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        int z = byteBuf.readInt();
        float volume = byteBuf.readFloat();
        byte pitch = byteBuf.readByte();
        
        return new PacketSoundEffect(soundName, x, y, z, volume, pitch);
    }
}
