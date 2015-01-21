package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketWorldBorder;
import com.captainbern.minecraft.net.session.Session;

public class HandlerWorldBorder implements Handler<Session, PacketWorldBorder> {

    @Override
    public void handle(Session session, PacketWorldBorder packet) {

    }    
}
