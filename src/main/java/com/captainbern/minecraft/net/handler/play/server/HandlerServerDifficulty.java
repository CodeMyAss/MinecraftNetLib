package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketServerDifficulty;
import com.captainbern.minecraft.net.session.Session;

public class HandlerServerDifficulty implements Handler<Session, PacketServerDifficulty> {

    @Override
    public void handle(Session session, PacketServerDifficulty packet) {

    }    
}
