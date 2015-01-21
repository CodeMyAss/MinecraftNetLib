package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketResourcePackStatus;
import com.captainbern.minecraft.net.session.Session;

public class HandlerResourcePackStatus implements Handler<Session, PacketResourcePackStatus> {

    @Override
    public void handle(Session session, PacketResourcePackStatus packet) {

    }    
}
