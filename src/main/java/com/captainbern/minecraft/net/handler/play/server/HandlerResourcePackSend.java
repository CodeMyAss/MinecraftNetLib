package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketResourcePackSend;
import com.captainbern.minecraft.net.session.Session;

public class HandlerResourcePackSend implements Handler<Session, PacketResourcePackSend> {

    @Override
    public void handle(Session session, PacketResourcePackSend packet) {

    }    
}
