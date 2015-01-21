package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketKeepAlive implements Packet {

    private int keepAliveId;

    public PacketKeepAlive(int id) {
        this.keepAliveId = id;
    }

    public int getKeepAliveId() {
        return this.keepAliveId;
    }
}
