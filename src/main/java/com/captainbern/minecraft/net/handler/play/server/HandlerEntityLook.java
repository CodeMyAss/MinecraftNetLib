package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityLook;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityLook implements Handler<Session, PacketEntityLook> {

    @Override
    public void handle(Session session, PacketEntityLook packet) {

    }    
}
