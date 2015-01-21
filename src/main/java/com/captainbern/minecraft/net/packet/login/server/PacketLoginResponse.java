package com.captainbern.minecraft.net.packet.login.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketLoginResponse implements AsyncablePacket {

    private String uuid;
    private String username;

    public PacketLoginResponse(String uuid, String username) {
        this.uuid = uuid;
        this.username = username;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
