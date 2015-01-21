package com.captainbern.minecraft.net.handler.login.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginSetCompression;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSetCompression implements Handler<Session, PacketLoginSetCompression> {

    @Override
    public void handle(Session session, PacketLoginSetCompression packet) {

    }    
}
