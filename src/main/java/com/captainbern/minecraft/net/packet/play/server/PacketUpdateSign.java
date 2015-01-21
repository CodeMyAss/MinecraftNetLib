package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.packet.Packet;

public class PacketUpdateSign implements Packet {

    private int x;
    private int y;
    private int z;

    private Message line1;
    private Message line2;
    private Message line3;
    private Message line4;

    public PacketUpdateSign(int x, int y, int z, Message line1 ,Message line2, Message line3, Message line4) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
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
    
    public Message getLine1(){
        return this.line1;
    }
    
    public Message getLine2(){
        return this.line2;
    }
    
    public Message getLine3(){
        return this.line3;
    }
    
    public Message getLine4(){
        return this.line4;
    }
}
