package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityVelocity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityVelocity implements Handler<Session, PacketEntityVelocity> {

    @Override
    public void handle(Session session, PacketEntityVelocity packet) {

    }    
}
