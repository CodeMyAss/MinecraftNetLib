package com.captainbern.minecraft.net.protocol;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecLookup;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.exception.InvalidOpcodeException;
import com.captainbern.minecraft.net.handler.Handler;
import com.captainbern.minecraft.net.handler.HandlerLookup;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public abstract class MinecraftProtocol implements Protocol {

    private static final Logger LOGGER = LogManager.getLogger(MinecraftProtocol.class);

    private Map<Side, CodecLookup> codecRegistry = Maps.newConcurrentMap();
    private Map<Side, HandlerLookup> handlerRegistry = Maps.newConcurrentMap();

    private final ProtocolState protocolState;

    public MinecraftProtocol(ProtocolState protocolState) {
        this.protocolState = protocolState;
    }

    public ProtocolState getProtocolState() {
        return this.protocolState;
    }

    @Override
    public String getId() {
        return this.getProtocolState().name().toLowerCase();
    }

    @Override
    public <P extends Packet> Handler<?, P> getHandlerFor(Side side, Class<P> packetClass) {
        return this.getHandlerLookupFor(side).getHandlerFor(packetClass);
    }

    @Override
    public <P extends Packet, H extends Handler<?, P>> void registerHandler(Side side, Class<P> packetClass, Class<H> handlerClass) throws InstantiationException, IllegalAccessException {
        this.getHandlerLookupFor(side).register(packetClass, handlerClass);
    }

    private HandlerLookup getHandlerLookupFor(Side side) {
        HandlerLookup handlerLookup = this.handlerRegistry.get(side);

        if (handlerLookup == null)
            handlerLookup = this.handlerRegistry.put(side, new HandlerLookup());

        return handlerLookup;
    }

    protected <P extends Packet, C extends Codec<P>> void registerClient(int opcode, Class<P> packet, Class<C> codec) {
        this.register(Side.CLIENT, opcode, packet, codec);
    }

    protected <P extends Packet, C extends Codec<P>> void registerServer(int opcode, Class<P> packet, Class<C> codec) {
        this.register(Side.SERVER, opcode, packet, codec);
    }

    protected <P extends Packet, C extends Codec<P>> void register(Side side, int opcode, Class<P> packet, Class<C> codec) {
        this.getLookupFor(side).register(opcode, packet, codec);
    }

    private CodecLookup getLookupFor(Side side) {
        CodecLookup lookup = this.codecRegistry.get(side);

        if (lookup == null)
            lookup = this.codecRegistry.put(side, new CodecLookup());

        return lookup;
    }

    @Override
    public <P extends Packet> CodecRegistrationEntry getCodecRegistration(Side side, Class<P> packetClass) {
        CodecRegistrationEntry registrationEntry = this.getLookupFor(side).getCodecFor(packetClass);

        if (registrationEntry == null) {
            getLogger().warn("Failed to find a CodecRegistrationEntry for packet: \'" + packetClass.getName() + "\'");
        }

        return registrationEntry;
    }

    @Override
    public Codec<?> readHeader(Side side, ByteBuf byteBuf) {
        int opcode = ByteBufUtils.readVarInt(byteBuf);
        Codec<?> codec = null;

        try {
            codec = this.getLookupFor(side).getCodecFor(opcode);
        } catch (InvalidOpcodeException e) {
            getLogger().warn("Failed to find an inbound packet for opcode: " + opcode);
        }

        return codec;
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    // TODO: This should be improved.
    // Perhaps provide a Protocol for multiple versions?
    public static int getProtocolVersion() {
        return 47;
    }
}
