package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketTitle;
import com.captainbern.minecraft.net.session.Session;

public class HandlerTitle implements Handler<Session, PacketTitle> {

    @Override
    public void handle(Session session, PacketTitle packet) {

    }    
}
