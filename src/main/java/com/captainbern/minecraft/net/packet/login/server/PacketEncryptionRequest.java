package com.captainbern.minecraft.net.packet.login.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;

public class PacketEncryptionRequest implements AsyncablePacket {

    private String serverId;
    private byte[] publicKey;
    private byte[] verifyToken;

    public PacketEncryptionRequest(String serverId, byte[] publicKey, byte[] verifyToken) {
        this.serverId = serverId;
        this.publicKey = publicKey;
        this.verifyToken = verifyToken;
    }

    public String getServerId() {
        return this.serverId;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public byte[] getVerifyToken() {
        return this.verifyToken;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
