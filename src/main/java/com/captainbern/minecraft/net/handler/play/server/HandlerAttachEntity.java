package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketAttachEntity;
import com.captainbern.minecraft.net.session.Session;

public class HandlerAttachEntity implements Handler<Session, PacketAttachEntity> {

    @Override
    public void handle(Session session, PacketAttachEntity packet) {

    }    
}
