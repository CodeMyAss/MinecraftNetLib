package com.captainbern.minecraft.net.handler.play.server;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityEquipment;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEntityEquipment implements Handler<Session, PacketEntityEquipment> {

    @Override
    public void handle(Session session, PacketEntityEquipment packet) {

    }    
}
