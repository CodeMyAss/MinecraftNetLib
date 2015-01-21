package com.captainbern.minecraft.net.pipeline;

import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

/**
 * Splitter/prepender
 */
public class FramingHandler extends ByteToMessageCodec<ByteBuf> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf packet, ByteBuf out) throws Exception {
        ByteBufUtils.writeVarInt(out, packet.readableBytes());
        out.writeBytes(packet);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        in.markReaderIndex();

        // check for length field readability
        in.markReaderIndex();
        if (!readableVarInt(in)) {
            return;
        }

        // check for contents readability
        int length = ByteBufUtils.readVarInt(in);
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }

        // read contents into buf
        ByteBuf buf = channelHandlerContext.alloc().buffer(length);
        in.readBytes(buf, length);
        list.add(buf);
    }

    private static boolean readableVarInt(ByteBuf buf) {
        if (buf.readableBytes() > 5) {
            // maximum varint size
            return true;
        }

        int idx = buf.readerIndex();
        byte in;
        do {
            if (buf.readableBytes() < 1) {
                buf.readerIndex(idx);
                return false;
            }
            in = buf.readByte();
        } while ((in & 0x80) != 0);

        buf.readerIndex(idx);
        return true;
    }
}
