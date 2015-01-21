package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSignEditorOpen;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSignEditorOpen implements Handler<Session, PacketSignEditorOpen> {

    @Override
    public void handle(Session session, PacketSignEditorOpen packet) {

    }    
}
