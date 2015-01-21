package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityEffect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityEffect implements Handler<Session, PacketEntityEffect> {

    @Override
    public void handle(Session session, PacketEntityEffect packet) {

    }    
}
