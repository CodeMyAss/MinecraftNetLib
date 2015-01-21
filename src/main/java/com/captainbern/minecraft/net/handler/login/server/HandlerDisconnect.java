package com.captainbern.minecraft.net.handler.login.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginKickDisconnect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerDisconnect implements Handler<Session, PacketLoginKickDisconnect> {

    @Override
    public void handle(Session session, PacketLoginKickDisconnect packet) {

    }    
}
