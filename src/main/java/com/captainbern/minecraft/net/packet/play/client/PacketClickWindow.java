package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.packet.Packet;

public class PacketClickWindow implements Packet {

    private byte windowId;
    private short slotId;
    private byte button;
    private short action;
    private byte mode;
    private ItemStack clickedItem;

    public PacketClickWindow(byte windowId, short slotId, byte button, short action, byte mode, ItemStack clickedItem) {
        this.windowId = windowId;
        this.slotId = slotId;
        this.button = button;
        this.action = action;
        this.mode = mode;
        this.clickedItem = clickedItem;
    }

    public byte getWindowId() {
        return this.windowId;
    }

    public short getSlotId() {
        return this.slotId;
    }

    public byte getButton() {
        return this.button;
    }

    public short getAction() {
        return this.action;
    }

    public byte getMode() {
        return this.mode;
    }

    public ItemStack getClickedItem() {
        return this.clickedItem;
    }
}
