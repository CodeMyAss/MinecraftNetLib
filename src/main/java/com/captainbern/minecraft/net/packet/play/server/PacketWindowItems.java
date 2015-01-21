package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketWindowItems implements Packet {

    private int windowId;
    private List<ItemStack> items;

    public PacketWindowItems(int windowId, List<ItemStack> items) {
        this.windowId = windowId;
        this.items = items;
    }

    public int getWindowId() {
        return this.windowId;
    }

    public List<ItemStack> getItems() {
        return this.items;
    }
}
