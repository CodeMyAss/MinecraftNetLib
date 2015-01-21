package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityLookAndRelativeMove;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityLookAndRelativeMove implements Handler<Session, PacketEntityLookAndRelativeMove> {

    @Override
    public void handle(Session session, PacketEntityLookAndRelativeMove packet) {

    }    
}
