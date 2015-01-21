package com.captainbern.minecraft.net.handler.status.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.status.client.PacketStatusRequest;
import com.captainbern.minecraft.net.session.Session;

public class HandlerRequest implements Handler<Session, PacketStatusRequest> {

    @Override
    public void handle(Session session, PacketStatusRequest packet) {

    }    
}
