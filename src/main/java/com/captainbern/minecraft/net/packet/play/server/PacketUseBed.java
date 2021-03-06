package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketUseBed implements Packet {

    private int entityId;

    private int x;
    private int y;
    private int z;

    public PacketUseBed(int entityId, int x, int y, int z) {
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
}
