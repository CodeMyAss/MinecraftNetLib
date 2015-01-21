package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketRespawn;
import com.captainbern.minecraft.net.session.Session;

public class HandlerRespawn implements Handler<Session, PacketRespawn> {

    @Override
    public void handle(Session session, PacketRespawn packet) {

    }    
}
