package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerUpdatePosition;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerPosition implements Handler<Session, PacketPlayerUpdatePosition> {

    @Override
    public void handle(Session session, PacketPlayerUpdatePosition packet) {

    }    
}
