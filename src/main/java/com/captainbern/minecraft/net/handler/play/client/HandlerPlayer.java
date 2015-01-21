package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerUpdate;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayer implements Handler<Session, PacketPlayerUpdate> {

    @Override
    public void handle(Session session, PacketPlayerUpdate packet) {

    }    
}
