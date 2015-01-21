package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSetCompression;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSetCompression implements Handler<Session, PacketSetCompression> {

    @Override
    public void handle(Session session, PacketSetCompression packet) {

    }    
}
