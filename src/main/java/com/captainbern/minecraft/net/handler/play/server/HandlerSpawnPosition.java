package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnPosition;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnPosition implements Handler<Session, PacketSpawnPosition> {

    @Override
    public void handle(Session session, PacketSpawnPosition packet) {

    }    
}
