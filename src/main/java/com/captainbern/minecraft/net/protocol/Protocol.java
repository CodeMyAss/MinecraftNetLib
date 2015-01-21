package com.captainbern.minecraft.net.protocol;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.packet.Packet;
import io.netty.buffer.ByteBuf;

public interface Protocol {

    public String getId();

    public <P extends Packet> CodecRegistrationEntry getCodecRegistration(Class<P> packetClass);

    public Codec<?> readHeader(ByteBuf byteBuf);
}
