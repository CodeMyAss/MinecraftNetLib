package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketEntityRelativeMove implements Packet {

    private int entityId;
    private byte dX;
    private byte dY;
    private byte dZ;
    private boolean onGround;

    public PacketEntityRelativeMove(int entityId, byte dX, byte dY, byte dZ, boolean onGround) {
        this.entityId = entityId;
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
        this.onGround = onGround;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public byte getX(){
        return this.dX;
    }
    
    public byte getY(){
        return this.dY;
    }
    
    public byte getZ(){
        return this.dZ;
    }
    
    public boolean isOnGround(){
        return this.onGround;
    }
}
