package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

public class PacketPluginMessage implements Packet {

    private String channel;
    private byte[] data;

    public PacketPluginMessage(String channel, byte[] data) {
        this.channel = channel;
        this.data = data;
    }

    public String getChannel() {
        return this.channel;
    }

    public byte[] getData() {
        return this.data;
    }
}
