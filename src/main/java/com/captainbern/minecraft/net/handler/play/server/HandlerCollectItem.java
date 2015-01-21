package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketCollectItem;
import com.captainbern.minecraft.net.session.Session;

public class HandlerCollectItem implements Handler<Session, PacketCollectItem> {

    @Override
    public void handle(Session session, PacketCollectItem packet) {

    }    
}
