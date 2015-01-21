package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSetExperience implements Packet {

    private float experienceBar; // Between 0 and 1
    private int level;
    private int totalExperience;

    public PacketSetExperience(float experienceBar, int level, int totalExperience) {
        this.experienceBar = experienceBar;
        this.level = level;
        this.totalExperience = totalExperience;
    }
    
    public float getExperienceBar(){
        return this.experienceBar;
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public int getTotalExperience(){
        return this.totalExperience;
    }
}
