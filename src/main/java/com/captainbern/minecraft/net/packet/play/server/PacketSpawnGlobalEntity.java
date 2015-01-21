package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSpawnGlobalEntity implements Packet {

    private int entityId;
    private byte type;
    private int x;
    private int y;
    private int z;

    public PacketSpawnGlobalEntity(int entityId, byte type, int x, int y, int z) {
        this.entityId = entityId;
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public byte getType(){
        return this.type;
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
}
