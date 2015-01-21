package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSpawnObject;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSpawnObject implements Codec<PacketSpawnObject> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnObject packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeByte(packet.getType());
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeInt(packet.getY());
        byteBuf.writeByte(packet.getPitch());
        byteBuf.writeByte(packet.getYaw());

        byteBuf.writeInt(packet.getData());
        if (packet.getData() != 0 && packet.getObjectData() != null) {
            byteBuf.writeShort(packet.getObjectData().getVelocityX());
            byteBuf.writeShort(packet.getObjectData().getVelocityY());
            byteBuf.writeShort(packet.getObjectData().getVelocityZ());
        }

        return byteBuf;
    }

    public PacketSpawnObject decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        byte type = byteBuf.readByte();
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        int z = byteBuf.readInt();
        byte pitch = byteBuf.readByte();
        byte yaw = byteBuf.readByte();

        int data = byteBuf.readInt();
        PacketSpawnObject.ObjectData objectData = null;
        if (data != 0) {
            short velocityX = byteBuf.readShort();
            short velocityY = byteBuf.readShort();
            short velocityZ = byteBuf.readShort();
            objectData = new PacketSpawnObject.ObjectData(velocityX, velocityY, velocityZ);
        }

        return new PacketSpawnObject(entityId, type, x, y, z, pitch, yaw, data, objectData);
    }
}
