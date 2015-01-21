package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSpawnPainting implements Packet {

    private int entityId;
    private String title;
    private int x;
    private int y;
    private int z;
    private byte direction; // Direction the painting faces (0 -z, 1 -x, 2 +z, 3 +x)

    public PacketSpawnPainting(int entityId, String title, int x, int y, int z, byte direction) {
        this.entityId = entityId;
        this.title = title;
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public String getTitle(){
        return this.title;
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
    
    public byte getDirection(){
        return this.direction;
    }
}
