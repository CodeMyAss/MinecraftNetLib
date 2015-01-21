package com.captainbern.minecraft.net.pipeline;

import com.captainbern.minecraft.net.ConnectionHandler;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.atomic.AtomicReference;

public class NetworkHandler extends SimpleChannelInboundHandler<Packet> {

    private final AtomicReference<Session> session = new AtomicReference<>(null);
    private final ConnectionHandler connectionHandler;

    public NetworkHandler(final ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public ConnectionHandler getConnectionHandler() {
        return this.connectionHandler;
    }

    public Session getSession() {
        return this.session.get();
    }

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        final Channel channel = channelHandlerContext.channel();
        Session netSession = this.connectionHandler.newSession(channel);
        if (!session.compareAndSet(null, netSession)) {
            throw new IllegalStateException("Session may not be set more than once");
        }
        netSession.onReady();
    }

    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        Session session = this.session.get();
        session.onDisconnect();
        this.connectionHandler.onSessionInactivated(session);
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {
        this.session.get().packetReceived(packet);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) {
       this.session.get().handleInboundException(cause);
    }
}
