package com.captainbern.minecraft.net.protocol;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecLookup;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.exception.InvalidOpcodeException;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftProtocol implements Protocol {

    private static final Logger LOGGER = LogManager.getLogger(MinecraftProtocol.class);

    public static final int PROTOCOL_VERSION = 47;

    private final Side side;
    private final ProtocolState protocolState;

    private CodecLookup serverLookup;
    private CodecLookup clientLookup;

    public MinecraftProtocol(Side side, ProtocolState protocolState) {
        this.side = side;
        this.protocolState = protocolState;

        this.serverLookup = new CodecLookup();
        this.clientLookup = new CodecLookup();
    }

    @Override
    public String getId() {
        return this.protocolState.name();
    }

    public <P extends Packet, C extends Codec<P>> void registerClient(int opcode, Class<P> packet, Class<C> codec) {
        this.register(Side.CLIENT, opcode, packet, codec);
    }

    public <P extends Packet, C extends Codec<P>> void registerServer(int opcode, Class<P> packet, Class<C> codec) {
        this.register(Side.SERVER, opcode, packet, codec);
    }

    public <P extends Packet, C extends Codec<P>> void register(Side side, int opcode, Class<P> packet, Class<C> codec) {
        this.getLookUpFor(side).register(packet, codec, opcode);
    }

    @Override
    public <P extends Packet> CodecRegistrationEntry getCodecRegistration(Class<P> packetClass) {
        CodecRegistrationEntry registrationEntry = this.getLookUpFor(this.side).getCodecFor(packetClass);

        if (registrationEntry == null) {
            getLogger().warn("Failed to find a CodecRegistrationEntry for packet: " + packetClass.getName());
        }

        return registrationEntry;
    }

    @Override
    public Codec<?> readHeader(ByteBuf byteBuf) {
        int opcode = ByteBufUtils.readVarInt(byteBuf);
        Codec<?> codec = null;

        try {
            codec = this.getLookUpFor(this.side.opposite()).getCodecFor(opcode);
        } catch (InvalidOpcodeException e) {
            getLogger().warn("Failed to find an inbound packet for opcode: " + opcode);
        }

        return codec;
    }

    private CodecLookup getLookUpFor(Side side) {
        switch (side) {
            case SERVER:
                return this.serverLookup;
            case CLIENT:
                return this.clientLookup;
            default:
                throw new RuntimeException("Failed to find a codec for: " + side.name());
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
