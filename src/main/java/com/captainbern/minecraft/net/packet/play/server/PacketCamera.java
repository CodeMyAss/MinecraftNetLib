package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketCamera implements Packet {

    int cameraId;

    public PacketCamera(int cameraId) {
        this.cameraId = cameraId;
    }

    public int getCameraId() {
        return this.cameraId;
    }
}
