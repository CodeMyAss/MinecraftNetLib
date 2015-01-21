package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateEntityNBT;
import com.captainbern.minecraft.net.session.Session;

public class HandlerUpdateEntityNBT implements Handler<Session, PacketUpdateEntityNBT> {

    @Override
    public void handle(Session session, PacketUpdateEntityNBT packet) {

    }    
}
