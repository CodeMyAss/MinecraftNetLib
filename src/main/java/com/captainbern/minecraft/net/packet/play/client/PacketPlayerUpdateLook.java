package com.captainbern.minecraft.net.packet.play.client;

public class PacketPlayerUpdateLook extends PacketPlayerUpdate {

    private float yaw;
    private float pitch;

    public PacketPlayerUpdateLook(float yaw, float pitch, boolean onGround) {
        super(onGround);
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }
}
