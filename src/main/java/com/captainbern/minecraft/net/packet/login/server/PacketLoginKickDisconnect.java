package com.captainbern.minecraft.net.packet.login.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketLoginKickDisconnect implements AsyncablePacket {

    private Message message;

    public PacketLoginKickDisconnect(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
