package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketExplosion;
import com.captainbern.minecraft.net.session.Session;

public class HandlerExplosion implements Handler<Session, PacketExplosion> {

    @Override
    public void handle(Session session, PacketExplosion packet) {

    }    
}
