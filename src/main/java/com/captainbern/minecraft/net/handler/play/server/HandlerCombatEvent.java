package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketCombatEvent;
import com.captainbern.minecraft.net.session.Session;

public class HandlerCombatEvent implements Handler<Session, PacketCombatEvent> {

    @Override
    public void handle(Session session, PacketCombatEvent packet) {

    }    
}
