package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketPlayerUpdate implements Packet {

    private boolean onGround;

    public PacketPlayerUpdate(boolean onGround) {
        this.onGround = onGround;
    }

    public boolean isOnGround() {
        return this.onGround;
    }
}
