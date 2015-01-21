package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketChangeGameState;
import com.captainbern.minecraft.net.session.Session;

public class HandlerChangeGameState implements Handler<Session, PacketChangeGameState> {

    @Override
    public void handle(Session session, PacketChangeGameState packet) {

    }    
}
