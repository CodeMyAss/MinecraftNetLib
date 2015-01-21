package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.net.packet.Packet;

public class PacketEntityEquipment implements Packet {

    private int entityId;
    private int slot;
    private ItemStack itemStack;

    public PacketEntityEquipment(int entityId, int slot, ItemStack itemStack) {
        this.entityId = entityId;
        this.slot = slot;
        this.itemStack = itemStack;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
