package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketSpectate;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpectate implements Handler<Session, PacketSpectate> {

    @Override
    public void handle(Session session, PacketSpectate packet) {

    }    
}
