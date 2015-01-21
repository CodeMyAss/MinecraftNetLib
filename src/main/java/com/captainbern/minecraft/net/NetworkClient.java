package com.captainbern.minecraft.net;

import com.captainbern.minecraft.net.pipeline.MinecraftChannelInitializer;
import com.captainbern.minecraft.net.protocol.Side;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.SocketAddress;

public abstract class NetworkClient implements ConnectionHandler {

    private final Bootstrap clientBootstrap = new Bootstrap();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    public NetworkClient() {
        this.clientBootstrap
                .group(this.workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new MinecraftChannelInitializer(this));
    }

    public ChannelFuture connect(final SocketAddress address) {
        return this.clientBootstrap.connect(address).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    NetworkClient.this.onConnectionSuccess();
                } else {
                    NetworkClient.this.onConnectionFailed(future.cause());
                }
            }
        });
    }

    @Override
    public final Side getSide() {
        return Side.CLIENT;
    }

    public void onConnectionSuccess() {}

    public void onConnectionFailed(Throwable cause) {}

    public void shutdown() {
        this.workerGroup.shutdownGracefully();
    }
}
