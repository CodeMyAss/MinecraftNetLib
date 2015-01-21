package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketScoreboardObjective;
import com.captainbern.minecraft.net.session.Session;

public class HandlerScoreboardObjective implements Handler<Session, PacketScoreboardObjective> {

    @Override
    public void handle(Session session, PacketScoreboardObjective packet) {

    }    
}
