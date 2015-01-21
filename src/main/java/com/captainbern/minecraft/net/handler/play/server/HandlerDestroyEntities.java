package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketDestroyEntities;
import com.captainbern.minecraft.net.session.Session;

public class HandlerDestroyEntities implements Handler<Session, PacketDestroyEntities> {

    @Override
    public void handle(Session session, PacketDestroyEntities packet) {

    }    
}
