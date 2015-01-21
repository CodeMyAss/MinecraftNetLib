package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketEntityLookAndRelativeMove implements Packet {

    private int entityId;
    private byte dX;
    private byte dY;
    private byte dZ;
    private byte yaw;
    private byte pitch;
    private boolean onGround;

    public PacketEntityLookAndRelativeMove(int entityId, byte dX, byte dY, byte dZ, byte yaw, byte pitch, boolean onGround) {
        this.entityId = entityId;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }
    
    public int getEntityId(){
        return entityId;
    }
    
    public byte getX(){
        return dX;
    }
    
    public byte getY(){
        return dY;
    }
    
    public byte getZ(){
        return dZ;
    }
    
    public byte getYaw(){
        return yaw;
    }
    
    public byte getPitch(){
        return pitch;
    }
    
    public boolean isOnGround(){
        return onGround;
    }

}
