package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketExplosion implements Packet {

    public static class BlockRecord {

        private byte x;
        private byte y;
        private byte z;

        public BlockRecord(byte x, byte y, byte z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public byte getX() {
            return this.x;
        }

        public byte getY() {
            return this.y;
        }

        public byte getZ() {
            return this.z;
        }
    }

    private float x;
    private float y;
    private float z;
    private float radius;
    private List<BlockRecord> blockRecordList;
    private float playerMotionX;
    private float playerMotionY;
    private float playerMotionZ;

    public PacketExplosion(float x, float y, float z, float radius, List<BlockRecord> records, float playerMotionX, float playerMotionY, float playerMotionZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.blockRecordList = records;
        this.playerMotionX = playerMotionX;
        this.playerMotionY = playerMotionY;
        this.playerMotionZ = playerMotionZ;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }

    public float getRadius() {
        return this.radius;
    }

    public List<BlockRecord> getBlockRecordList() {
        return this.blockRecordList;
    }

    public float getPlayerMotionX() {
        return this.playerMotionX;
    }

    public float getPlayerMotionY() {
        return this.playerMotionY;
    }

    public float getPlayerMotionZ() {
        return this.playerMotionZ;
    }
}
