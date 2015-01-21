package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockBreakAnimation;
import com.captainbern.minecraft.net.session.Session;

public class HandlerBlockBreakAnimation implements Handler<Session, PacketBlockBreakAnimation> {

    @Override
    public void handle(Session session, PacketBlockBreakAnimation packet) {

    }    
}
