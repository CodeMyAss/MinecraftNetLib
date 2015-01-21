package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSteerVehicle implements Packet {

    private float sideways;
    private float forward;
    private boolean jump;
    private boolean unmount;

    public PacketSteerVehicle(float sideways, float forward, boolean jump, boolean unmount) {
        this.sideways = sideways;
        this.forward = forward;
        this.jump = jump;
        this.unmount = unmount;
    }

    public float getSideways() {
        return this.sideways;
    }

    public float getForward() {
        return this.forward;
    }

    public boolean isJump() {
        return this.jump;
    }

    public boolean isUnmount() {
        return this.unmount;
    }
}
