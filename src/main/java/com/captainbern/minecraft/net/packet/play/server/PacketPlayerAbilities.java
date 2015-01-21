package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketPlayerAbilities implements Packet {

    private int flags; // is an unsigned byte
    private float flyingSpeed;
    private float walkSpeed;

    public PacketPlayerAbilities(int flags, float flyingSpeed, float walkSpeed) {
        this.flags = flags;
        this.flyingSpeed = flyingSpeed;
        this.walkSpeed = walkSpeed;
    }

    public int getFlags() {
        return this.flags;
    }

    public float getFlyingSpeed() {
        return this.flyingSpeed;
    }

    public float getWalkSpeed() {
        return this.walkSpeed;
    }
}
