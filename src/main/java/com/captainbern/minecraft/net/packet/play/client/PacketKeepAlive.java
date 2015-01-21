package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

public class PacketKeepAlive implements Packet {

    public int keepAliveId;

    public PacketKeepAlive(int keepAliveId) {
        this.keepAliveId = keepAliveId;
    }

    public int getKeepAliveId() {
        return this.keepAliveId;
    }
}
