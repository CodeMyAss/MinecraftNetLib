package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateHealth;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateHealth implements Handler<Session, PacketUpdateHealth> {

    @Override
    public void handle(Session session, PacketUpdateHealth packet) {

    }    
}
