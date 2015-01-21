package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerUpdateLook;
import com.captainbern.minecraft.net.session.Session;

public class HandlerPlayerLook implements Handler<Session, PacketPlayerUpdateLook> {

    @Override
    public void handle(Session session, PacketPlayerUpdateLook packet) {

    }    
}
