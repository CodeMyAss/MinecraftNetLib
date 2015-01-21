package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnPlayer;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSpawnPlayer implements Handler<Session, PacketSpawnPlayer> {

    @Override
    public void handle(Session session, PacketSpawnPlayer packet) {

    }    
}
