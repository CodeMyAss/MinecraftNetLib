package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketDigging;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerDigging implements Handler<Session, PacketDigging> {

    @Override
    public void handle(Session session, PacketDigging packet) {

    }    
}
