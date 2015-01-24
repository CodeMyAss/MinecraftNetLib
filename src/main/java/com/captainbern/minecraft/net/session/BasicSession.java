package com.captainbern.minecraft.net.session;

import com.captainbern.minecraft.net.ConnectionHandler;
import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.Protocol;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.List;

public abstract class BasicSession implements Session {

    protected final ConnectionHandler connectionHandler;
    protected Channel channel;
    protected Protocol protocol;

    public BasicSession(ConnectionHandler connectionHandler, Channel channel, Protocol protocol) {
        this.connectionHandler = connectionHandler;
        this.channel = channel;
        this.protocol = protocol;
    }

    public void handlePacket(Packet packet) {
        Class<? extends Packet> packetClass = packet.getClass();
        Object handlersObject = this.protocol.getHandlersFor(packetClass);

        if (handlersObject != null) {
            List<Handler> handlers = ((List<Handler>) handlersObject); // Have to do this ugly hack because of type-safety. TODO: find a better way to do this
            for (Handler handler : handlers) {
                handler.handle(this, packet);
            }
        }
    }

    @Override
    public ConnectionHandler getConnectionHandler() {
        return this.connectionHandler;
    }

    @Override
    public void packetReceived(Packet packet) {
        this.handlePacket(packet);
    }

    @Override
    public void sendPacket(Packet packet) {
        sendPacketWithFuture(packet);
    }

    public ChannelFuture sendPacketWithFuture(Packet packet) {
        if (!isAlive())
            throw new ChannelException("Channel is closed!");

        return this.channel.writeAndFlush(packet).addListener(new GenericFutureListener<Future<Void>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.cause() != null)
                    BasicSession.this.handleOutboundException(future.cause());
            }
        });
    }

    @Override
    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public boolean isAlive() {
        return this.channel.isActive();
    }

    @Override
    public Channel getChannel() {
        return this.channel;
    }

    @Override
    public void disconnect() {
        this.channel.close();
    }
}
