package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketSteerVehicle;
import com.captainbern.minecraft.net.session.Session;

public class HandlerSteerVehicle implements Handler<Session, PacketSteerVehicle> {

    @Override
    public void handle(Session session, PacketSteerVehicle packet) {

    }    
}
