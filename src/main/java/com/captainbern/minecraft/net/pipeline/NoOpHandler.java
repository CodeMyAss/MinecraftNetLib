package com.captainbern.minecraft.net.pipeline;

import io.netty.channel.ChannelHandlerAdapter;

public class NoOpHandler extends ChannelHandlerAdapter {

    public static final NoOpHandler INSTANCE = new NoOpHandler();

    public NoOpHandler() {

    }
}
