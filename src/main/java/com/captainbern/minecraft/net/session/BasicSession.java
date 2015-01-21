package com.captainbern.minecraft.net.session;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.Protocol;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public abstract class BasicSession implements Session {

    protected Channel channel;
    protected Protocol protocol;

    public BasicSession(Channel channel, Protocol protocol) {
        this.channel = channel;
        this.protocol = protocol;
    }

    public abstract void handlePacket(Packet packet);

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
