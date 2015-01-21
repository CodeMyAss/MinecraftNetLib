package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.packet.Packet;

public class PacketSetSlot implements Packet {

    private byte windowId;
    private short slot;
    private ItemStack itemStack;

    public PacketSetSlot(byte windowId, short slot, ItemStack itemStack) {
        this.windowId = windowId;
        this.slot = slot;
        this.itemStack = itemStack;
    }

    public byte getWindowId() {
        return this.windowId;
    }

    public short getSlot() {
        return this.slot;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
