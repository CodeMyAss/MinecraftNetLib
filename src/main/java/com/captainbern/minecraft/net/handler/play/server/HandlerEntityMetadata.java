package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityMetadata;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityMetadata implements Handler<Session, PacketEntityMetadata> {

    @Override
    public void handle(Session session, PacketEntityMetadata packet) {

    }    
}
