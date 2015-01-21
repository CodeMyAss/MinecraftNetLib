package com.captainbern.minecraft.net.protocol;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.packet.Packet;
import io.netty.buffer.ByteBuf;

public interface Protocol {

    public String getId();

    public <P extends Packet> Handler<?, P> getHandlerFor(Side side, Class<P> packetClass);

    public <P extends Packet, H extends Handler<?, P>> void registerHandler(Side side, Class<P> packetClass, Class<H> handlerClass) throws InstantiationException, IllegalAccessException;

    public <P extends Packet> CodecRegistrationEntry getCodecRegistration(Side side, Class<P> packetClass);

    public Codec<?> readHeader(Side side, ByteBuf byteBuf);
}
