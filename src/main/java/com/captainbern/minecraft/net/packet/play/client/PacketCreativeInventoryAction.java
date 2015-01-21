package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.packet.Packet;

public class PacketCreativeInventoryAction implements Packet {

    private short slot;
    private ItemStack item;

    public PacketCreativeInventoryAction(short slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

    public short getSlot() {
        return this.slot;
    }

    public ItemStack getItem() {
        return this.item;
    }
}
