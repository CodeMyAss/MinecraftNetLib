package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketCollectItem implements Packet {

    private int itemEntityId;
    private int collectorId;

    public PacketCollectItem(int itemEntityId, int collectorId) {
        this.itemEntityId = itemEntityId;
        this.collectorId = collectorId;
    }

    public int getItemEntityId() {
        return this.itemEntityId;
    }

    public int getCollectorId() {
        return this.collectorId;
    }
}
