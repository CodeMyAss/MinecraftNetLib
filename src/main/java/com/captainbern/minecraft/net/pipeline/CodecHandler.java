package com.captainbern.minecraft.net.pipeline;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.codec.CodecRegistrationEntry;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.Side;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

@SuppressWarnings("unchecked")
public class CodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    private final NetworkHandler networkHandler;
    private final Side side;

    public CodecHandler(NetworkHandler networkHandler) {
        this.networkHandler = networkHandler;
        this.side = this.networkHandler.getConnectionHandler().getSide();
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> list) throws Exception {
        Class<? extends Packet> packetClass = packet.getClass();
        CodecRegistrationEntry registrationEntry = this.networkHandler.getSession().getProtocol().getCodecRegistration(this.side, packetClass);

        if (registrationEntry == null) {
            throw new EncoderException("Failed to find a CodecRegistrationEntry for packet: " + packetClass.getName());
        }

        ByteBuf header = channelHandlerContext.alloc().buffer(8);
        ByteBufUtils.writeVarInt(header, registrationEntry.getOpcode());

        ByteBuf contents = channelHandlerContext.alloc().buffer();
        contents = registrationEntry.getCodec().encode(contents, packet);

        list.add(Unpooled.wrappedBuffer(header, contents));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Codec<?> codec = this.networkHandler.getSession().getProtocol().readHeader(this.side.opposite(), byteBuf);
        Packet decoded = codec.decode(byteBuf);

        if (byteBuf.readableBytes() > 0) {
            MinecraftProtocol.getLogger().warn("Leftover bytes (" + byteBuf.readableBytes() + ") after decoding: " + decoded);
        }

        list.add(decoded);
    }
}
