package com.captainbern.minecraft.net.packet.status.client;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketStatusRequest implements AsyncablePacket {

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
