package com.captainbern.minecraft.net.packet.login.client;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketLoginRequest implements AsyncablePacket {

    private String name;

    public PacketLoginRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
