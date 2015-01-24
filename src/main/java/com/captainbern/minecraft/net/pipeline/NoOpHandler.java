package com.captainbern.minecraft.net.pipeline;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;

@ChannelHandler.Sharable
public class NoOpHandler extends ChannelHandlerAdapter {

    public static final NoOpHandler INSTANCE = new NoOpHandler();

    private NoOpHandler() {}
}
