package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityTeleport;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityTeleport implements Handler<Session, PacketEntityTeleport> {

    @Override
    public void handle(Session session, PacketEntityTeleport packet) {

    }    
}
