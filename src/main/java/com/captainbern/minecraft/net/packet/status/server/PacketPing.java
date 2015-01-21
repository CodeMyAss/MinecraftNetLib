package com.captainbern.minecraft.net.packet.status.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketPing implements AsyncablePacket {

    private long time;

    public PacketPing(long time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
