package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketCamera;
import com.captainbern.minecraft.net.session.Session;

public class HandlerCamera implements Handler<Session, PacketCamera> {

    @Override
    public void handle(Session session, PacketCamera packet) {

    }    
}
