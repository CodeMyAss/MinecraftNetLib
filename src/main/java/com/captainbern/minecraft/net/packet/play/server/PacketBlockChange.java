package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketBlockChange implements Packet {

    private int x;
    private int y;
    private int z;
    private int type;

    public PacketBlockChange(int x, int y, int z, int type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    public PacketBlockChange(int x, int y, int z, int id, int metadata) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = ((id << 4) | (metadata & 0xf));
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

    public int getType() {
        return this.type;
    }
}
