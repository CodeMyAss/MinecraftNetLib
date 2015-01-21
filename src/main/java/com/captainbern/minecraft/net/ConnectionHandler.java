package com.captainbern.minecraft.net;

import com.captainbern.minecraft.net.session.Session;
import io.netty.channel.Channel;

public interface ConnectionHandler {

    public Session newSession(Channel channel);

    public void onSessionInactivated(Session session);

    public void shutdown();
}
