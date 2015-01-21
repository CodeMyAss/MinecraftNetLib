package com.captainbern.minecraft.net.codec.login.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.client.PacketEncryptionResponse;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEncryptionResponse implements Codec<PacketEncryptionResponse> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketEncryptionResponse packet) {
        byte[] sharedSecret = packet.getSharedSecret();
        ByteBufUtils.writeVarInt(byteBuf, sharedSecret.length);
        byteBuf.writeBytes(sharedSecret);

        byte[] verifyToken = packet.getVerifyToken();
        ByteBufUtils.writeVarInt(byteBuf, verifyToken.length);
        byteBuf.writeBytes(verifyToken);

        return byteBuf;
    }

    @Override
    public PacketEncryptionResponse decode(ByteBuf byteBuf) {
        int sharedSecretLength = ByteBufUtils.readVarInt(byteBuf);
        byte[] sharedSecret = new byte[sharedSecretLength];
        byteBuf.readBytes(sharedSecret);

        int verifyTokenLength = ByteBufUtils.readVarInt(byteBuf);
        byte[] verifyToken = new byte[verifyTokenLength];
        byteBuf.readBytes(verifyToken);

        return new PacketEncryptionResponse(sharedSecret, verifyToken);
    }
}
