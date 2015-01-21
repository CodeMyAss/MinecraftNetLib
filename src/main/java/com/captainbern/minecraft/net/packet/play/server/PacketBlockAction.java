package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketBlockAction implements Packet {

    private int x;
    private int y;
    private int z;

    private byte data1;
    private byte data2;

    private int blockId;

    public PacketBlockAction(int x, int y, int z, byte data1, byte data2, int blockId) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.data1 = data1;
        this.data2 = data2;
        this.blockId = blockId;
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

    public byte getData1() {
        return this.data1;
    }

    public byte getData2() {
        return this.data2;
    }

    public int getBlockId() {
        return this.blockId;
    }
}
