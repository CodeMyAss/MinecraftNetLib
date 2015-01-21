package com.captainbern.minecraft.net;

import com.captainbern.minecraft.net.protocol.Side;
import com.captainbern.minecraft.net.session.Session;
import io.netty.channel.Channel;

public interface ConnectionHandler {

    public Side getSide();

    public Session newSession(Channel channel);

    public void onSessionInactivated(Session session);

    public void shutdown();
}
