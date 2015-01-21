package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketRemoveEntityEffect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerRemoveEntityEffect implements Handler<Session, PacketRemoveEntityEffect> {

    @Override
    public void handle(Session session, PacketRemoveEntityEffect packet) {

    }    
}
