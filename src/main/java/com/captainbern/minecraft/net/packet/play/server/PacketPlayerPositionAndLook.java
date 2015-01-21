package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketPlayerPositionAndLook implements Packet {

    public enum Flag{
        X(0x01),
        Y(0x02),
        Z(0x04),
        YAW(0x08),
        PITCH(0x10);
        
        private final int value;

        private Flag(int value){
            this.value = value;
        }
        
        public int getValue(){
            return this.value;
        }
    }
    
    private double x; // Absolute/Relative position
    private double y; // Absolute/Relative position
    private double z; // Absolute/Relative position
    private float yaw; // Absolute/Relative rotation on the X Axis, in degrees
    private float pitch; // Absolute/Relative rotation on the Y Axis, in degrees
    private byte flags; // X 0x01 Y 0x02 Z 0x04 Y_ROT 0x08 X_ROT 0x10

    public PacketPlayerPositionAndLook(double x, double y, double z, float yaw, float pitch, byte flags) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.flags = flags;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
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
    
    public boolean isRelative(Flag flag){
        return (this.flags & flag.getValue()) == flag.getValue();
    }

    public byte getFlags() {
        return this.flags;
    }
    
}
