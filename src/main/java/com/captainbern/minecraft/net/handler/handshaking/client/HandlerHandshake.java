package com.captainbern.minecraft.net.handler.handshaking.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.handshake.client.PacketHandshake;
import com.captainbern.minecraft.net.session.Session;

public class HandlerHandshake implements Handler<Session, PacketHandshake> {

    @Override
    public void handle(Session session, PacketHandshake packet) {

    }    
}
