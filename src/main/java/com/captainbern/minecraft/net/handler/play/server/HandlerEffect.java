package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEffect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEffect implements Handler<Session, PacketEffect> {

    @Override
    public void handle(Session session, PacketEffect packet) {

    }    
}
