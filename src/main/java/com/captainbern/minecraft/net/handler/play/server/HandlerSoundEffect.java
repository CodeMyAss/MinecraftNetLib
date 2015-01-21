package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketSoundEffect;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSoundEffect implements Handler<Session, PacketSoundEffect> {

    @Override
    public void handle(Session session, PacketSoundEffect packet) {

    }    
}
