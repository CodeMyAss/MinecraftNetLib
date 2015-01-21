package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketParticle;
import com.captainbern.minecraft.net.session.Session;

public class HandlerParticle implements Handler<Session, PacketParticle> {

    @Override
    public void handle(Session session, PacketParticle packet) {

    }    
}
