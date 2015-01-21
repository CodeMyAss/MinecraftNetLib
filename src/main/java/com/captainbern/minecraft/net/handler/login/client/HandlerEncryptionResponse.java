package com.captainbern.minecraft.net.handler.login.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.login.client.PacketEncryptionResponse;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEncryptionResponse implements Handler<Session, PacketEncryptionResponse> {

    @Override
    public void handle(Session session, PacketEncryptionResponse packet) {

    }    
}
