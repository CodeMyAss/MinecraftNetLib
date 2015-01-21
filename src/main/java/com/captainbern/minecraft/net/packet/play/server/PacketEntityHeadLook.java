package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketEntityHeadLook implements Packet {

    private int entityId; // Entity's ID
    private byte headYaw; // Head yaw in steps of 2p/256

    public PacketEntityHeadLook(int entityId,byte headYaw) {
        this.entityId=entityId;
        this.headYaw=headYaw;
    }
    
    public int getEntityId(){
        return entityId;
    }
    
    public byte getHeadYaw(){
        return headYaw;
    }
}
