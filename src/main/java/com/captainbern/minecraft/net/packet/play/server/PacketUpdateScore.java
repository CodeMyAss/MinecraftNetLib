package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketUpdateScore implements Packet {

    private String scoreName; // The name of the score to be updated or removed.
    private byte action; // 0 to create/update an item. 1 to remove an item. // TODO: Perhaps create en enum for this?
    private String objectiveName; // The name of the objective the score belongs to.
    private int value; // The score to be displayed next to the entry. Only sent when Update/Remove does not equal 1.

    public PacketUpdateScore(String scoreName, byte action, String objectiveName, int value) {
        this.scoreName = scoreName;
        this.action = action;
        this.objectiveName = objectiveName;
        this.value = value;
    }
    
    public String getScoreName(){
        return this.scoreName;
    }
    
    public byte getAction(){
        return this.action;
    }
    
    public String getObjectiveName(){
        return this.objectiveName;
    }
    
    public int getValue(){
        return this.value;
    }
}
