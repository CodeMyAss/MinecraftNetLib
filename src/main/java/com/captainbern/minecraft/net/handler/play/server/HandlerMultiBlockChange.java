package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketMultiBlockChange;
import com.captainbern.minecraft.net.session.Session;

public class HandlerMultiBlockChange implements Handler<Session, PacketMultiBlockChange> {

    @Override
    public void handle(Session session, PacketMultiBlockChange packet) {

    }    
}