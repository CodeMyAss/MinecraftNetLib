package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockChange;
import com.captainbern.minecraft.net.session.Session;

public class HandlerBlockChange implements Handler<Session, PacketBlockChange> {

    @Override
    public void handle(Session session, PacketBlockChange packet) {

    }    
}
