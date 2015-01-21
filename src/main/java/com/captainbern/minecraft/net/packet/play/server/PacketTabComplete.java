package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketTabComplete implements Packet {

    private int count;
    private String[] matches;

    public PacketTabComplete(int count, String[] matches) {
        this.count = count;
        this.matches = matches;
    }
    
    public int getCount(){
        return this.count;
    }
    
    public String[] getMatches(){
        return this.matches;
    }
}
