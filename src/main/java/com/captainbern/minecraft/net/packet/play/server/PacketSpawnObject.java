package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketSpawnObject implements Packet {

    public static class ObjectData {

        private short velocityX;
        private short velocityY;
        private short velocityZ;

        public ObjectData(short velocityX, short velocityY, short velocityZ) {
            this.velocityX = velocityX;
            this.velocityY = velocityY;
            this.velocityZ = velocityZ;
        }

        public short getVelocityX() {
            return this.velocityX;
        }

        public short getVelocityY() {
            return this.velocityY;
        }

        public short getVelocityZ() {
            return this.velocityZ;
        }
    }

    private int entityId;
    private byte type;
    private int x;
    private int y;
    private int z;
    private byte pitch;
    private byte yaw;
    private int data;
    private ObjectData objectData; // is null when 'data' == 0

    public PacketSpawnObject(int entityId, byte type, int x, int y, int z, byte pitch, byte yaw, int data, ObjectData objectData) {
        this.entityId = entityId;
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.data = data;
        this.objectData = objectData;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public byte getType() {
        return this.type;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public byte getPitch() {
        return this.pitch;
    }

    public byte getYaw() {
        return this.yaw;
    }

    public int getData() {
        return this.data;
    }

    public ObjectData getObjectData() {
        return this.objectData;
    }
}
