package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockAction;
import com.captainbern.minecraft.net.session.Session;

public class HandlerBlockAction implements Handler<Session, PacketBlockAction> {

    @Override
    public void handle(Session session, PacketBlockAction packet) {

    }    
}
