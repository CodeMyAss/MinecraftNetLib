package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketJoinGame;
import com.captainbern.minecraft.net.session.Session;

public class HandlerJoinGame implements Handler<Session, PacketJoinGame> {

    @Override
    public void handle(Session session, PacketJoinGame packet) {

    }    
}
