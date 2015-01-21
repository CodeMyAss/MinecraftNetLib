package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.game.chat.Message;

public class PacketPlayerListHeaderFooter implements Packet {

    private Message header;
    private Message footer;

    public PacketPlayerListHeaderFooter(Message header, Message footer) {
        this.header = header;
        this.footer = footer;
    }

    public Message getHeader() {
        return this.header;
    }
    
    public Message getFooter() {
        return this.footer;
    }
}
