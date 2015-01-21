package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketWindowItems;
import com.captainbern.minecraft.net.session.Session;

public class HandlerWindowItems implements Handler<Session, PacketWindowItems> {

    @Override
    public void handle(Session session, PacketWindowItems packet) {

    }    
}
