package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketEnchantItem implements Packet {

    private byte windowId;
    private byte enchantment;

    public PacketEnchantItem(byte windowId, byte enchantment) {
        this.windowId = windowId;
        this.enchantment = enchantment;
    }

    public byte getWindowId() {
        return this.windowId;
    }

    public byte getEnchantment() {
        return this.enchantment;
    }
}
