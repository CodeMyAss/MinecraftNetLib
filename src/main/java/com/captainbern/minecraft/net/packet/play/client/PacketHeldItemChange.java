package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

public class PacketHeldItemChange implements Packet {

    private short slot;

    public PacketHeldItemChange(short slot) {
        this.slot = slot;
    }

    public short getSlot() {
        return this.slot;
    }
}
