package com.captainbern.minecraft.net.protocol;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.Packet;
import io.netty.buffer.ByteBuf;

import java.util.List;

public interface Protocol {

    public String getId();

    public <P extends Packet> List<Handler<?, P>> getHandlersFor(Class<P> packetClass);

    public void registerHandlers(String packageName);

    public <P extends Packet, H extends Handler<?, P>> void registerHandler(Class<H> handlerClass);

    public <P extends Packet> CodecRegistrationEntry getCodecRegistration(Side side, Class<P> packetClass);

    public Codec<?> readHeader(Side side, ByteBuf byteBuf);
}
