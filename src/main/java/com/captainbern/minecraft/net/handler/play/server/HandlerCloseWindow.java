package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketCloseWindow;
import com.captainbern.minecraft.net.session.Session;

public class HandlerCloseWindow implements Handler<Session, PacketCloseWindow> {

    @Override
    public void handle(Session session, PacketCloseWindow packet) {

    }    
}
