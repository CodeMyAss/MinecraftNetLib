package com.captainbern.minecraft.net.pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.List;

public class EncryptionHandler extends MessageToMessageCodec<ByteBuf, ByteBuf> {

    private final PacketEncryptionHandler encrypter;
    private final PacketEncryptionHandler decrypter;

    public EncryptionHandler(SecretKey secretKey) {
        try {
            this.encrypter = new PacketEncryptionHandler(Cipher.ENCRYPT_MODE, secretKey);
            this.decrypter = new PacketEncryptionHandler(Cipher.DECRYPT_MODE, secretKey);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to initialize the EncryptionHandler!", e);
        }
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.encrypter.handle(byteBuf, list);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.decrypter.handle(byteBuf, list);
    }

    private static class PacketEncryptionHandler {

        private Cipher cipher;

        public PacketEncryptionHandler(int cipherMode, SecretKey secretKey) throws GeneralSecurityException {
            this.cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            this.cipher.init(cipherMode, secretKey, new IvParameterSpec(secretKey.getEncoded()));
        }

        public void handle(ByteBuf byteBuf, List<Object> list) {
            ByteBuffer out = ByteBuffer.allocate(byteBuf.readableBytes());

            try {
                this.cipher.update(byteBuf.nioBuffer(), out);
            } catch (ShortBufferException e) {
                throw new RuntimeException("Encryption buffer was too short!", e);
            }

            out.flip();
            list.add(Unpooled.wrappedBuffer(out));
        }
    }
}
