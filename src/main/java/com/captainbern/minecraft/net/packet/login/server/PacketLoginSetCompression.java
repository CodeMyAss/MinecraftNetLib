package com.captainbern.minecraft.net.packet.login.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketLoginSetCompression implements AsyncablePacket {

    private int threshold;

    public PacketLoginSetCompression(int threshold) {
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
