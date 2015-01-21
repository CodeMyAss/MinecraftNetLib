package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketDisconnect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerDisconnect implements Handler<Session, PacketDisconnect> {

    @Override
    public void handle(Session session, PacketDisconnect packet) {

    }    
}
