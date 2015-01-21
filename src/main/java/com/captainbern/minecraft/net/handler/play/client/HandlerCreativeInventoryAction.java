package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketCreativeInventoryAction;
import com.captainbern.minecraft.net.session.Session;

public class HandlerCreativeInventoryAction implements Handler<Session, PacketCreativeInventoryAction> {

    @Override
    public void handle(Session session, PacketCreativeInventoryAction packet) {

    }    
}
