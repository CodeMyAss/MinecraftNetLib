package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketUseEntity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUseEntity implements Handler<Session, PacketUseEntity> {

    @Override
    public void handle(Session session, PacketUseEntity packet) {

    }    
}
