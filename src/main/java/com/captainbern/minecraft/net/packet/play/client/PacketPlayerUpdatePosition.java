package com.captainbern.minecraft.net.packet.play.client;

public class PacketPlayerUpdatePosition extends PacketPlayerUpdate {

    private double x;
    private double feetY;
    private double z;

    public PacketPlayerUpdatePosition(double x, double feetY, double z, boolean onGround) {
        super(onGround);
        this.x = x;
        this.feetY = feetY;
        this.z = z;
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
}
