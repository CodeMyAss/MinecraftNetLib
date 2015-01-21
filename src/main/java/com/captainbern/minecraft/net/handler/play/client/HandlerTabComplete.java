package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketTabComplete;
import com.captainbern.minecraft.net.session.Session;

public class HandlerTabComplete implements Handler<Session, PacketTabComplete> {

    @Override
    public void handle(Session session, PacketTabComplete packet) {

    }    
}
