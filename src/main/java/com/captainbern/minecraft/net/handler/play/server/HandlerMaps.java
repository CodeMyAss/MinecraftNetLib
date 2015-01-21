package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketMaps;
import com.captainbern.minecraft.net.session.Session;

public class HandlerMaps implements Handler<Session, PacketMaps> {

    @Override
    public void handle(Session session, PacketMaps packet) {

    }    
}
