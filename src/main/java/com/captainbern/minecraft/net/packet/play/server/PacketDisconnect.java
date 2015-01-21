package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.captainbern.litebot.util.chat.Message;

public class PacketDisconnect implements Packet {

    private Message message;

    public PacketDisconnect(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }
}
