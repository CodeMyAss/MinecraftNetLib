package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateSign;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateSign implements Handler<Session, PacketUpdateSign> {

    @Override
    public void handle(Session session, PacketUpdateSign packet) {

    }    
}
