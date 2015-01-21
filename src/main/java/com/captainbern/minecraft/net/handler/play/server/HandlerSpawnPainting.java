package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnPainting;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnPainting implements Handler<Session, PacketSpawnPainting> {

    @Override
    public void handle(Session session, PacketSpawnPainting packet) {

    }    
}
