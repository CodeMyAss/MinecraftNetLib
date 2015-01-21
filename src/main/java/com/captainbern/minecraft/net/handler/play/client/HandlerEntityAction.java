package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketEntityAction;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityAction implements Handler<Session, PacketEntityAction> {

    @Override
    public void handle(Session session, PacketEntityAction packet) {

    }    
}
