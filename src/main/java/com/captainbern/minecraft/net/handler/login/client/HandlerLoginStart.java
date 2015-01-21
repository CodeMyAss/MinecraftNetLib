package com.captainbern.minecraft.net.handler.login.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.client.PacketLoginRequest;
import com.captainbern.minecraft.net.session.Session;

public class HandlerLoginStart implements Handler<Session, PacketLoginRequest> {

    @Override
    public void handle(Session session, PacketLoginRequest packet) {

    }    
}
