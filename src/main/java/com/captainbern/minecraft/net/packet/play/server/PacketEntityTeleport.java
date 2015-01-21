package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketEntityTeleport implements Packet {

    private int entityId;
    private int x;
    private int y;
    private int z;
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketEntityTeleport(int entityId, int x, int y, int z, byte yaw, byte pitch, boolean onGround) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getZ(){
        return this.z;
    }
    
    public byte getYaw(){
        return this.yaw;
    }
    
    public byte getPitch(){
        return this.pitch;
    }
    
    public boolean isOnGround(){
        return this.onGround;
    }
}
