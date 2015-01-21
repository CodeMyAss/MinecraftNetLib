package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketBlockBreakAnimation implements Packet {

    private int entityId; // varint Entity's ID
    private int x;
    private int y;
    private int z;
    private byte stage;

    public PacketBlockBreakAnimation(int entityId, int x, int y, int z, byte stage) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.stage = stage;
    }

    public int getEntityId() {
        return this.entityId;
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

    public byte getStage() {
        return this.stage;
    }
}
