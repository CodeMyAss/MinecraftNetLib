package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketParticle;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecParticle implements Codec<PacketParticle> {

    public ByteBuf encode(ByteBuf byteBuf, PacketParticle packet) {
        byteBuf.writeInt(packet.getParticleType());
        byteBuf.writeBoolean(packet.isLongDistance());
        byteBuf.writeFloat(packet.getX());
        byteBuf.writeFloat(packet.getY());
        byteBuf.writeFloat(packet.getZ());
        byteBuf.writeFloat(packet.getOffsetX());
        byteBuf.writeFloat(packet.getOffsetY());
        byteBuf.writeFloat(packet.getOffsetZ());
        byteBuf.writeFloat(packet.getParticleData());
        byteBuf.writeInt(packet.getParticleCount());
        for (int i = 0; i < packet.getData().length; i++) {
            ByteBufUtils.writeVarInt(byteBuf, packet.getData()[i]);
        }
        
        return byteBuf;
    }

    public PacketParticle decode(ByteBuf byteBuf) {
        int particleType = byteBuf.readInt();
        boolean longDistance = byteBuf.readBoolean();
        float x = byteBuf.readFloat();
        float y = byteBuf.readFloat();
        float z = byteBuf.readFloat();
        float offsetX = byteBuf.readFloat();
        float offsetY = byteBuf.readFloat();
        float offsetZ = byteBuf.readFloat();
        float particleData = byteBuf.readFloat();
        int particleCount = byteBuf.readInt();
        int data[] = new int[PacketParticle.ParticleType.getById(particleType).getLength()];
        for (int i = 0; i < data.length; i++) {
            data[i] = ByteBufUtils.readVarInt(byteBuf);
        }
        
        return new PacketParticle(particleType, longDistance, x, y, z, offsetX, offsetY, offsetZ, particleData, particleCount, data);
    }
}
