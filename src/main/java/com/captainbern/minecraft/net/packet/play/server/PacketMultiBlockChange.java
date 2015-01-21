package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

import java.util.List;

public class PacketMultiBlockChange implements Packet {

    private int x;
    private int z;
    private List<PacketBlockChange> records;

    public PacketMultiBlockChange(int x, int z, List<PacketBlockChange> records) {
        this.x = x;
        this.z = z;
        this.records = records;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public List<PacketBlockChange> getRecords() {
        return this.records;
    }
}
