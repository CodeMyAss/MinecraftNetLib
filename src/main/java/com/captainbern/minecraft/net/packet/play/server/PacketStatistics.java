package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

import java.util.Map;

public class PacketStatistics implements Packet {

    private Map<String,Integer> entries;
    
    public PacketStatistics(Map<String, Integer> entries) {
        this.entries = entries;
    }
    
    public Map<String,Integer> getEntries(){
        return this.entries;
    }
}
