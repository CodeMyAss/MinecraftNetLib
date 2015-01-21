package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketStatistics;
import com.captainbern.minecraft.net.session.Session;

public class HandlerStatistics implements Handler<Session, PacketStatistics> {

    @Override
    public void handle(Session session, PacketStatistics packet) {

    }    
}
