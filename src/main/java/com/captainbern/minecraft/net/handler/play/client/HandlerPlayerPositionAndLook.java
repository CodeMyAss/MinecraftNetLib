package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerPositionAndLook;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerPositionAndLook implements Handler<Session, PacketPlayerPositionAndLook> {

    @Override
    public void handle(Session session, PacketPlayerPositionAndLook packet) {

    }    
}
