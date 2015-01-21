package com.captainbern.minecraft.net.handler.status.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.status.client.PacketPing;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPing implements Handler<Session, PacketPing> {

    @Override
    public void handle(Session session, PacketPing packet) {

    }    
}
