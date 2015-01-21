package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityRelativeMove;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityRelativeMove implements Handler<Session, PacketEntityRelativeMove> {

    @Override
    public void handle(Session session, PacketEntityRelativeMove packet) {

    }    
}
