package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketDestroyEntities implements Packet {

    private int[] ids;

    public PacketDestroyEntities(int[] ids) {
        this.ids = ids;
    }

    public int[] getIds() {
        return this.ids;
    }
}
