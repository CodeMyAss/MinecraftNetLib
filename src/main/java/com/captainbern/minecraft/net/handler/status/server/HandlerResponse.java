package com.captainbern.minecraft.net.handler.status.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.status.server.PacketStatusResponse;
import com.captainbern.minecraft.net.session.Session;

public class HandlerResponse implements Handler<Session, PacketStatusResponse> {

    @Override
    public void handle(Session session, PacketStatusResponse packet) {

    }    
}
