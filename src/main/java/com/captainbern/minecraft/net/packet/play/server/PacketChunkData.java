package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketChunkData implements Packet {

    private int x;
    private int z;
    boolean continuous;
    private int bitmask;
    private byte[] data;

    public PacketChunkData(int x, int z, boolean continuous, int bitmask, byte[] data) {
        this.x = x;
        this.z = z;
        this.continuous = continuous;
        this.bitmask = bitmask;
        this.data = data;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public int getBitmask() {
        return this.bitmask;
    }

    public byte[] getData() {
        return this.data;
    }
}
