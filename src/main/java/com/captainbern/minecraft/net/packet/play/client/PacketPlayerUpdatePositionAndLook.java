package com.captainbern.minecraft.net.packet.play.client;

public class PacketPlayerUpdatePositionAndLook extends PacketPlayerUpdate {

    private double x;
    private double feetY;
    private double z;

    private float yaw;
    private float pitch;

    public PacketPlayerUpdatePositionAndLook(double x, double feetY, double z, float yaw, float pitch, boolean onGround) {
        super(onGround);
        this.x = x;
        this.feetY = feetY;
        this.z = z;

        this.yaw = yaw;
        this.pitch = pitch;
    }

    public double getX() {
        return this.x;
    }

    public double getFeetY() {
        return this.feetY;
    }

    public double getZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }
}
