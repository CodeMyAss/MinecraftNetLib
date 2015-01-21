package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnObject;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnObject implements Handler<Session, PacketSpawnObject> {

    @Override
    public void handle(Session session, PacketSpawnObject packet) {

    }    
}
