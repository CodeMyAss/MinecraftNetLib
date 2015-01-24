package com.captainbern.minecraft.net.pipeline;

import com.captainbern.minecraft.net.ConnectionHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.util.concurrent.TimeUnit;

public class MinecraftChannelInitializer extends ChannelInitializer<Channel> {

    private final ConnectionHandler connectionHandler;

    public MinecraftChannelInitializer(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        NetworkHandler networkHandler = new NetworkHandler(this.connectionHandler);

        channel.pipeline()
                .addLast("read_timeout", new ReadTimeoutHandler(30, TimeUnit.SECONDS))
                .addLast("encryption_handler", NoOpHandler.INSTANCE)
                .addLast("framing_handler", new FramingHandler())
                .addLast("compression_handler", NoOpHandler.INSTANCE)
                .addLast("codec_handler", new CodecHandler(networkHandler))
                .addLast("net_manager", networkHandler);
    }
}
