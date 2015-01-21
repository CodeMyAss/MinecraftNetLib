package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateScore;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateScore implements Handler<Session, PacketUpdateScore> {

    @Override
    public void handle(Session session, PacketUpdateScore packet) {

    }    
}
