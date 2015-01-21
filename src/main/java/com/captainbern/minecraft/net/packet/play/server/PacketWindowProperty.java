package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketWindowProperty implements Packet {

    //UNSIGNED
    private byte windowId;
    private short property;
    private short value;

    public PacketWindowProperty(byte windowId, short property, short value) {
        this.windowId = windowId;
        this.property = property;
        this.value = value;
    }
    
    public byte getWindowId(){
        return this.windowId;
    }
    
    public short getProperty(){
        return this.property;
    }
    
    public short getValue(){
        return this.value;
    }
}
