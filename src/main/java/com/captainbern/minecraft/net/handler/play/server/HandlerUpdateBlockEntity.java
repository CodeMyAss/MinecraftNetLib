package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateBlockEntity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateBlockEntity implements Handler<Session, PacketUpdateBlockEntity> {

    @Override
    public void handle(Session session, PacketUpdateBlockEntity packet) {

    }    
}
