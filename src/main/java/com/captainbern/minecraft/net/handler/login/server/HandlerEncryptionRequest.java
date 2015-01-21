package com.captainbern.minecraft.net.handler.login.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.server.PacketEncryptionRequest;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEncryptionRequest implements Handler<Session, PacketEncryptionRequest> {

    @Override
    public void handle(Session session, PacketEncryptionRequest packet) {

    }    
}
