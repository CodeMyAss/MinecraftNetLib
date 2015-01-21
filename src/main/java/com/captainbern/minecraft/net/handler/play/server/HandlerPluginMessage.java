package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketPluginMessage;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPluginMessage implements Handler<Session, PacketPluginMessage> {

    @Override
    public void handle(Session session, PacketPluginMessage packet) {

    }    
}
