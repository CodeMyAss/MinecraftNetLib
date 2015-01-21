package com.captainbern.minecraft.net.session;

import com.captainbern.minecraft.net.ConnectionHandler;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.Protocol;
import io.netty.channel.Channel;

public interface Session {

    public ConnectionHandler getConnectionHandler();

    public void packetReceived(Packet packet);

    public void sendPacket(Packet packet);

    public Protocol getProtocol();

    public boolean isAlive();

    public Channel getChannel();

    public void onReady();

    public void disconnect();

    public void onDisconnect();

    public void handleInboundException(Throwable throwable);

    public void handleOutboundException(Throwable throwable);

    public void onHandlerException(Throwable throwable);
}
