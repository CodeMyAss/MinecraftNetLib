package com.captainbern.minecraft.net.handler.play.client;

import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.play.client.PacketEnchantItem;
import com.captainbern.minecraft.net.session.Session;

public class HandlerEnchantItem implements Handler<Session, PacketEnchantItem> {

    @Override
    public void handle(Session session, PacketEnchantItem packet) {

    }    
}
