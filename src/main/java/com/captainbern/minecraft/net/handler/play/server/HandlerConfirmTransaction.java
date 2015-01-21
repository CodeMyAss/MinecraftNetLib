package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketConfirmTransaction;
import com.captainbern.minecraft.net.session.Session;

public class HandlerConfirmTransaction implements Handler<Session, PacketConfirmTransaction> {

    @Override
    public void handle(Session session, PacketConfirmTransaction packet) {

    }    
}
