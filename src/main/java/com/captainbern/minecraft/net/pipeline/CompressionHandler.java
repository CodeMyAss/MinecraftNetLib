package com.captainbern.minecraft.net.pipeline;

import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionHandler extends MessageToMessageCodec<ByteBuf, ByteBuf> {

    private static final int COMPRESSION_LEVEL = Deflater.DEFAULT_COMPRESSION;

    private final int threshold;
    private final Inflater inflater;
    private final Deflater deflater;

    public CompressionHandler(int threshold) {
        this.threshold = threshold;
        this.inflater = new Inflater();
        this.deflater = new Deflater(COMPRESSION_LEVEL);
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf header = channelHandlerContext.alloc().buffer(5);
        ByteBuf content;

        if (byteBuf.readableBytes() >= this.threshold) {
            int readerIndex = byteBuf.readerIndex();
            int length = byteBuf.readableBytes();

            byte[] decompressed = new byte[length];
            byteBuf.readBytes(decompressed);
            this.deflater.setInput(decompressed);
            this.deflater.finish();

            byte[] compressed = new byte[length];
            int compressedLength = this.deflater.deflate(compressed);
            this.deflater.reset();

            if (compressedLength == 0) {
                throw new EncoderException("Failed to compress packet of size: " + length);
            } else if (compressedLength >= length) {
                ByteBufUtils.writeVarInt(header, 0);
                byteBuf.readerIndex(readerIndex);
                byteBuf.retain();
                content = byteBuf;
            } else {
                ByteBufUtils.writeVarInt(header, 0);
                content = Unpooled.wrappedBuffer(compressed, 0, compressedLength);
            }
        } else {
            ByteBufUtils.writeVarInt(header, 0);
            byteBuf.retain();
            content = byteBuf;
        }

        list.add(Unpooled.wrappedBuffer(header, content));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readerIndex = byteBuf.readerIndex();
        int decompressedSize = ByteBufUtils.readVarInt(byteBuf);
        int length = byteBuf.readableBytes();

        if (decompressedSize == 0) {
            if (length >= this.threshold) {
                throw new DecoderException("Received uncompressed packet of size: " + length + ", greater than threshold of: " + this.threshold);
            }

            ByteBuf buf = channelHandlerContext.alloc().buffer();
            byteBuf.readBytes(buf, length);
            list.add(buf);
        } else {
            byte[] compressed = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(compressed);
            this.inflater.setInput(compressed);

            byte[] decompressed = new byte[decompressedSize];
            int decompressedLength = this.inflater.inflate(decompressed);
            this.inflater.reset();

            if (decompressedLength == 0) {

                byteBuf.readerIndex(readerIndex);
                byteBuf.retain();
                list.add(byteBuf);

            } else if (decompressedLength != decompressedSize) {
                throw new DecoderException("Decompressed packet should have a size of: " + decompressedSize + " but actually has a size of: " + decompressedLength);
            } else {
                list.add(Unpooled.wrappedBuffer(decompressed));
            }
        }
    }
}
