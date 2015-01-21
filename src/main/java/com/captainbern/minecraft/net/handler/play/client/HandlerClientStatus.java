package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketClientStatus;
import com.captainbern.minecraft.net.session.Session;

public class HandlerClientStatus implements Handler<Session, PacketClientStatus> {

    @Override
    public void handle(Session session, PacketClientStatus packet) {

    }    
}
