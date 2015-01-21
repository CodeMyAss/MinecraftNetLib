package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketUpdateSign;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateSign implements Handler<Session, PacketUpdateSign> {

    @Override
    public void handle(Session session, PacketUpdateSign packet) {

    }    
}
