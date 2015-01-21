package com.captainbern.minecraft.net.packet.handshake.client;

import com.captainbern.minecraft.net.packet.AsyncablePacket;
import com.captainbern.minecraft.net.protocol.ProtocolState;

public class PacketHandshake implements AsyncablePacket {

    private int protocolVersion;
    private String serverAddress;
    private int serverPort;
    private ProtocolState nextState;

    public PacketHandshake(int protocolVersion, String serverAddress, int serverPort, ProtocolState protocolState) {
        this.protocolVersion = protocolVersion;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.nextState = protocolState;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getServerAddress() {
        return this.serverAddress;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public ProtocolState getNextState() {
        return this.nextState;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
