package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketParticle;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecParticle implements Codec<PacketParticle> {

    public ByteBuf encode(ByteBuf byteBuf, PacketParticle packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getParticleType());
        byteBuf.writeBoolean(packet.isLongDistance());
        byteBuf.writeFloat(packet.getX());
        byteBuf.writeFloat(packet.getY());
        byteBuf.writeFloat(packet.getZ());
        byteBuf.writeFloat(packet.getOffsetX());
        byteBuf.writeFloat(packet.getOffsetY());
        byteBuf.writeFloat(packet.getOffsetZ());
        byteBuf.writeFloat(packet.getParticleData());
        ByteBufUtils.writeVarInt(byteBuf, packet.getParticleCount());
        //TODO: WHEN WE KNOW THE BLOODY VARIABLE LENGTH PACKETS, WE HANDLE THEM HERE
        
        return byteBuf;
    }

    public PacketParticle decode(ByteBuf byteBuf) {
        int particleType = ByteBufUtils.readVarInt(byteBuf);
        boolean longDistance = byteBuf.readBoolean();
        float x = byteBuf.readFloat();
        float y = byteBuf.readFloat();
        float z = byteBuf.readFloat();
        float offsetX = byteBuf.readFloat();
        float offsetY = byteBuf.readFloat();
        float offsetZ = byteBuf.readFloat();
        float particleData = byteBuf.readFloat();
        int particleCount = ByteBufUtils.readVarInt(byteBuf);
        int data[] = null;
        //TODO: HANDLE THE BLOODY DATA
        
        return new PacketParticle(particleType, longDistance, x, y, z, offsetX, offsetY, offsetZ, particleData, particleCount, data);
    }
}
