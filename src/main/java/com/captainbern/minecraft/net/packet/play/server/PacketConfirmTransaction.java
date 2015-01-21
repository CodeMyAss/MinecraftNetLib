package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketConfirmTransaction implements Packet {

    private byte windowId;
    private short action;
    private boolean accepted;

    public PacketConfirmTransaction(byte windowId, short action, boolean accepted) {
        this.windowId = windowId;
        this.action = action;
        this.accepted = accepted;
    }

    public byte getWindowId() {
        return this.windowId;
    }

    public short getAction() {
        return this.action;
    }

    public boolean isAccepted() {
        return this.accepted;
    }
}
