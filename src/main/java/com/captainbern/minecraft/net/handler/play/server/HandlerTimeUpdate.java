package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketTimeUpdate;
import com.captainbern.minecraft.net.session.Session;

public class HandlerTimeUpdate implements Handler<Session, PacketTimeUpdate> {

    @Override
    public void handle(Session session, PacketTimeUpdate packet) {

    }    
}
