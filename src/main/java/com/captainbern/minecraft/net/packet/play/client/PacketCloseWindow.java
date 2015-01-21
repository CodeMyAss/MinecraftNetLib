package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

public class PacketCloseWindow implements Packet {

    private byte windowId;

    public PacketCloseWindow(byte windowId) {
        this.windowId = windowId;
    }

    public byte getWindowId() {
        return this.windowId;
    }
}
