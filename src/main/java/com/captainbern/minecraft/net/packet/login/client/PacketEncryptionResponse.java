package com.captainbern.minecraft.net.packet.login.client;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketEncryptionResponse implements AsyncablePacket {

    private byte[] sharedSecret;
    private byte[] verifyToken;

    public PacketEncryptionResponse(byte[] sharedSecret, byte[] verifyToken) {
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public byte[] getSharedSecret() {
        return this.sharedSecret;
    }

    public byte[] getVerifyToken() {
        return this.verifyToken;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
