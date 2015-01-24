package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketSetCompression implements AsyncablePacket {

    private int threshold;

    public PacketSetCompression(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return this.threshold;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
