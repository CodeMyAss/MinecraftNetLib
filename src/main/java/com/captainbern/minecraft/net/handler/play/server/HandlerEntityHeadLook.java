package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityHeadLook;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityHeadLook implements Handler<Session, PacketEntityHeadLook> {

    @Override
    public void handle(Session session, PacketEntityHeadLook packet) {

    }    
}
