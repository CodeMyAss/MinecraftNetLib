package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketClientChatMessage;
import com.captainbern.minecraft.net.session.Session;

public class HandlerClientChatMessage implements Handler<Session, PacketClientChatMessage> {

    @Override
    public void handle(Session session, PacketClientChatMessage packet) {

    }    
}
