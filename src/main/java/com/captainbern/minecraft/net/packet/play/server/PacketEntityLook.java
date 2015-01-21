package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketEntityLook implements Packet {

    private int entityId;
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketEntityLook(int entityId, byte yaw, byte pitch, boolean onGround) {
        this.entityId = entityId;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }
    
    public int getEntityId(){
        return this.entityId;
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
