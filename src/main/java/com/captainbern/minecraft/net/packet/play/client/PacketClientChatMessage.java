package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketClientChatMessage implements AsyncablePacket {

    private String message;

    public PacketClientChatMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
