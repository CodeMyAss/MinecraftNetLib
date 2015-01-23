package com.captainbern.minecraft.net.handler.test;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.session.Session;

public interface Handler<S extends Session, P extends Packet> {

    public void handle(S session, P packet);
}
