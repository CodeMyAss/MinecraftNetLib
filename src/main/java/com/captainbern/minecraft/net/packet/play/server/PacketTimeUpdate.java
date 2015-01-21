package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketTimeUpdate implements Packet {

    private long ageOfWorld;
    private long timeOfDay;

    public PacketTimeUpdate(long ageOfWorld, long timeOfDay) {
        this.ageOfWorld = ageOfWorld;
        this.timeOfDay = timeOfDay;
    }
    
    public long getAgeOfWorld(){
        return this.ageOfWorld;
    }
    
    public long getTimeOfDay(){
        return this.timeOfDay;
    }
}
