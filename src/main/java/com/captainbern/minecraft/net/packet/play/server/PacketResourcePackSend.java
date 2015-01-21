package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketResourcePackSend implements Packet {

    private String url;
    private String hash;

    public PacketResourcePackSend(String url, String hash) {
        this.url = url;
        this.hash = hash;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHash() {
        return this.hash;
    }
}
