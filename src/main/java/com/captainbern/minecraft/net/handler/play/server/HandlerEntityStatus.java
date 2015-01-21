package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityStatus;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityStatus implements Handler<Session, PacketEntityStatus> {

    @Override
    public void handle(Session session, PacketEntityStatus packet) {

    }    
}
