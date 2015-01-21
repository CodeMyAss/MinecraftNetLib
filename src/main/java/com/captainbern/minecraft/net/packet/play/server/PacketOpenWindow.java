package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.game.chat.Message;

public class PacketOpenWindow implements Packet {

    //UNSIGNED BYTE
    private short windowId; // A unique id number for the window to be displayed. Notchian server implementation is a counter, starting at 1.
    private String inventoryType; // The window type to use for display. Check below
    private Message windowTitle; // The title of the window.
    //UNSIGNED BYTE
    private short numberOfSlots; // Number of slots in the window (excluding the number of slots in the player inventory).
    private int entityId; // EntityHorse's entityId. Only sent when window type is equal to "EntityHorse".

    public PacketOpenWindow(byte windowId, String inventoryType, Message windowTitle, byte numberOfSlots, int entityId) {
        this.windowId = (short)(windowId&0xFF);
        this.inventoryType = inventoryType;
        this.windowTitle = windowTitle;
        this.numberOfSlots = (short)(numberOfSlots&0xFF);
        this.entityId = entityId;
    }

    public short getWindowId() {
        return this.windowId;
    }
    
    public String getInventoryType(){
        return this.inventoryType;
    }
    
    public Message getWindowTitle(){
        return this.windowTitle;
    }
    
    public short getNumberOfSlots(){
        return this.numberOfSlots;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
}
