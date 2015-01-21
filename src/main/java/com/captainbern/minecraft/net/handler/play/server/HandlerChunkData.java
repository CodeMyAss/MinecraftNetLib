package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketChunkData;
import com.captainbern.minecraft.net.session.Session;

public class HandlerChunkData implements Handler<Session, PacketChunkData> {

    @Override
    public void handle(Session session, PacketChunkData packet) {

    }    
}
