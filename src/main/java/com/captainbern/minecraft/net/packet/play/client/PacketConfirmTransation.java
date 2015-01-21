package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketConfirmTransation implements Packet {

    /**
     * SEE MORE: http://wiki.vg/Protocol#Confirm_Transaction_2
     */

    private byte windowId;
    private short action;
    private boolean accepted;

    public PacketConfirmTransation(byte windowId, short action, boolean accepted) {
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
