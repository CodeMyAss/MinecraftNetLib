package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketRemoveEntityEffect implements Packet {

    private int entityId; // Entity's ID
    private byte effectId;

    public PacketRemoveEntityEffect(int entityId, byte effectId) {
        this.entityId = entityId;
        this.effectId = effectId;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public byte getEffectId(){
        return this.effectId;
    }
}
