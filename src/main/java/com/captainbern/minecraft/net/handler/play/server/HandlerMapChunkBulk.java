package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketMapChunkBulk;
import com.captainbern.minecraft.net.session.Session;

public class HandlerMapChunkBulk implements Handler<Session, PacketMapChunkBulk> {

    @Override
    public void handle(Session session, PacketMapChunkBulk packet) {

    }    
}
