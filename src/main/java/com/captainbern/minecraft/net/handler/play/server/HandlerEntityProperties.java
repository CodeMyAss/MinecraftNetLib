package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityProperties;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityProperties implements Handler<Session, PacketEntityProperties> {

    @Override
    public void handle(Session session, PacketEntityProperties packet) {

    }    
}
