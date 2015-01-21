package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSpawnExperienceOrb implements Packet {

    private int entityId;
    private int x;
    private int y;
    private int z;
    private short count;

    public PacketSpawnExperienceOrb(int entityId, int x, int y, int z, short count) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
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
    
    public short getCount(){
        return this.count;
    }
}
