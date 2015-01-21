package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketEntityVelocity implements Packet {

    private int entityId;
    private short velocityX;
    private short velocityY;
    private short velocityZ;

    public PacketEntityVelocity(int entityId, short velocityX, short velocityY, short velocityZ) {
        this.entityId = entityId;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public short getVelocityX(){
        return this.velocityX;
    }
    
    public short getVelocityY(){
        return this.velocityY;
    }
    
    public short getVelocityZ(){
        return this.velocityZ;
    }
}
