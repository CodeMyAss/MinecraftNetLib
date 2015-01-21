package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListItem;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerListItem implements Handler<Session, PacketPlayerListItem> {

    @Override
    public void handle(Session session, PacketPlayerListItem packet) {

    }    
}
