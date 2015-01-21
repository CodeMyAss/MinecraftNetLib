package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketWindowProperty;
import com.captainbern.minecraft.net.session.Session;

public class HandlerWindowProperty implements Handler<Session, PacketWindowProperty> {

    @Override
    public void handle(Session session, PacketWindowProperty packet) {

    }    
}
