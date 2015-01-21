package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSetExperience;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSetExperience implements Handler<Session, PacketSetExperience> {

    @Override
    public void handle(Session session, PacketSetExperience packet) {

    }    
}
