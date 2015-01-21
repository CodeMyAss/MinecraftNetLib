package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketHeldItemChange;
import com.captainbern.minecraft.net.session.Session;

public class HandlerHeldItemChange implements Handler<Session, PacketHeldItemChange> {

    @Override
    public void handle(Session session, PacketHeldItemChange packet) {

    }    
}
