package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerAbilities;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerAbilities implements Handler<Session, PacketPlayerAbilities> {

    @Override
    public void handle(Session session, PacketPlayerAbilities packet) {

    }    
}
