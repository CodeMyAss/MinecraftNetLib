package com.captainbern.minecraft.net;

import com.captainbern.minecraft.net.pipeline.MinecraftChannelInitializer;
import com.captainbern.minecraft.net.protocol.Side;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.SocketAddress;

public abstract class NetworkServer implements ConnectionHandler {

    private final ServerBootstrap serverBootstrap = new ServerBootstrap();
    private final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private final EventLoopGroup workerGroup = new NioEventLoopGroup();

    public NetworkServer() {
        this.serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MinecraftChannelInitializer(this))
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    public ChannelFuture bind(final SocketAddress address) {
        return serverBootstrap.bind(address).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    NetworkServer.this.onBindSuccess(address);
                } else {
                    NetworkServer.this.onBindFailure(address, future.cause());
                }
            }
        });
    }

    @Override
    public final Side getSide() {
        return Side.SERVER;
    }

    public void onBindSuccess(SocketAddress socketAddress) {}

    public void onBindFailure(SocketAddress socketAddress, Throwable throwable) {}

    @Override
    public void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}
