package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketPlayerAbilities implements Packet {

    private byte flags;
    private float flySpeed;
    private float walkSpeed;

    public PacketPlayerAbilities(byte flags, float flySpeed, float walkSpeed) {
        this.flags = flags;
        this.flySpeed = flySpeed;
        this.walkSpeed = walkSpeed;
    }

    public byte getFlags() {
        return this.flags;
    }

    public float getFlySpeed() {
        return this.flySpeed;
    }

    public float getWalkSpeed() {
        return this.walkSpeed;
    }
}
