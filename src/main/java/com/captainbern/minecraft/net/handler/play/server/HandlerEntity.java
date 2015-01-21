package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntity implements Handler<Session, PacketEntity> {

    @Override
    public void handle(Session session, PacketEntity packet) {

    }    
}
