package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSetSlot;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSetSlot implements Handler<Session, PacketSetSlot> {

    @Override
    public void handle(Session session, PacketSetSlot packet) {

    }    
}
