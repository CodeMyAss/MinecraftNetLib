package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketClientSettings;
import com.captainbern.minecraft.net.session.Session;

public class HandlerClientSettings implements Handler<Session, PacketClientSettings> {

    @Override
    public void handle(Session session, PacketClientSettings packet) {

    }    
}
