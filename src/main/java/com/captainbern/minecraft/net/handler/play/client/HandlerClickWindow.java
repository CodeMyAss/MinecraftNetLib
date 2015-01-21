package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketClickWindow;
import com.captainbern.minecraft.net.session.Session;

public class HandlerClickWindow implements Handler<Session, PacketClickWindow> {

    @Override
    public void handle(Session session, PacketClickWindow packet) {

    }    
}
