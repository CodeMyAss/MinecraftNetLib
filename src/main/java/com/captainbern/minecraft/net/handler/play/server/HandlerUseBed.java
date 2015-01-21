package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUseBed;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUseBed implements Handler<Session, PacketUseBed> {

    @Override
    public void handle(Session session, PacketUseBed packet) {

    }    
}
