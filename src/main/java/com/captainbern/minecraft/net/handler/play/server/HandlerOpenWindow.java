package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketOpenWindow;
import com.captainbern.minecraft.net.session.Session;

public class HandlerOpenWindow implements Handler<Session, PacketOpenWindow> {

    @Override
    public void handle(Session session, PacketOpenWindow packet) {

    }    
}
