package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketKeepAlive;
import com.captainbern.minecraft.net.session.Session;

public class HandlerKeepAlive implements Handler<Session, PacketKeepAlive> {

    @Override
    public void handle(Session session, PacketKeepAlive packet) {

    }    
}
