package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.packet.Packet;

public class PacketDisconnect implements Packet {

    private Message message;

    public PacketDisconnect(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }
}
