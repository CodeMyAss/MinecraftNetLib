package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketEffect implements Packet {

    private int effectId;
    private int x;
    private int y;
    private int z;
    private int data;
    private boolean ignoreDistance;

    public PacketEffect(int effectId, int x, int y, int z, int data, boolean ignoreDistance) {
        this.effectId = effectId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.data = data;
        this.ignoreDistance = ignoreDistance;
    }

    public int getEffectId() {
        return this.effectId;
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

    public int getData() {
        return this.data;
    }

    public boolean isIgnoreDistance() {
        return this.ignoreDistance;
    }
}
