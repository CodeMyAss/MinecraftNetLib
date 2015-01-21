package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketPlaceBlock;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerBlockPlacement implements Handler<Session, PacketPlaceBlock> {

    @Override
    public void handle(Session session, PacketPlaceBlock packet) {

    }    
}
