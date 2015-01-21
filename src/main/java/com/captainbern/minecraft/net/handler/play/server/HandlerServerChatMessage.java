package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketServerChatMessage;
import com.captainbern.minecraft.net.session.Session;

public class HandlerServerChatMessage implements Handler<Session, PacketServerChatMessage> {

    @Override
    public void handle(Session session, PacketServerChatMessage packet) {

    }    
}
