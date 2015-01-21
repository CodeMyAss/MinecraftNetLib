package com.captainbern.minecraft.net.codec.login.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.login.server.PacketEncryptionRequest;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEncryptionRequest implements Codec<PacketEncryptionRequest> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketEncryptionRequest packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getServerId());

        byte[] publicKey = packet.getPublicKey();
        ByteBufUtils.writeVarInt(byteBuf, publicKey.length);
        byteBuf.writeBytes(publicKey);

        byte[] secretKey = packet.getVerifyToken();
        ByteBufUtils.writeVarInt(byteBuf, secretKey.length);
        byteBuf.writeBytes(secretKey);

        return byteBuf;
    }

    @Override
    public PacketEncryptionRequest decode(ByteBuf byteBuf) {
        String serverId = ByteBufUtils.readUTF(byteBuf);

        int publicKeyLength = ByteBufUtils.readVarInt(byteBuf);
        byte[] publicKey = new byte[publicKeyLength];
        byteBuf.readBytes(publicKey);

        int privateKeyLength = ByteBufUtils.readVarInt(byteBuf);
        byte[] secretKey = new byte[privateKeyLength];
        byteBuf.readBytes(secretKey);

        return new PacketEncryptionRequest(serverId, publicKey, secretKey);
    }
}
