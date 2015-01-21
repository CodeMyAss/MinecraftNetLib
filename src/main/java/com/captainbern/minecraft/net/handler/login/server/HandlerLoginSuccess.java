package com.captainbern.minecraft.net.handler.login.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginResponse;
import com.captainbern.minecraft.net.session.Session;

public class HandlerLoginSuccess implements Handler<Session, PacketLoginResponse> {

    @Override
    public void handle(Session session, PacketLoginResponse packet) {

    }    
}
