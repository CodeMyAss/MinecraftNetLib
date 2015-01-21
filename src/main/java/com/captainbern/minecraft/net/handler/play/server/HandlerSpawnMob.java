package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnMob;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnMob implements Handler<Session, PacketSpawnMob> {

    @Override
    public void handle(Session session, PacketSpawnMob packet) {

    }    
}
