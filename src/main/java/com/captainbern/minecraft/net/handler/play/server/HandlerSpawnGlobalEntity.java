package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnGlobalEntity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnGlobalEntity implements Handler<Session, PacketSpawnGlobalEntity> {

    @Override
    public void handle(Session session, PacketSpawnGlobalEntity packet) {

    }    
}
