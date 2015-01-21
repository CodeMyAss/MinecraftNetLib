package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketTeams;
import com.captainbern.minecraft.net.session.Session;

public class HandlerTeams implements Handler<Session, PacketTeams> {

    @Override
    public void handle(Session session, PacketTeams packet) {

    }    
}
