package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListHeaderFooter;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerListHeaderFooter implements Handler<Session, PacketPlayerListHeaderFooter> {

    @Override
    public void handle(Session session, PacketPlayerListHeaderFooter packet) {

    }    
}
