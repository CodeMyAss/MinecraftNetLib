package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

import java.util.List;

public class PacketMapChunkBulk implements Packet {

    private boolean hasSkylight;
    private List<PacketChunkData> chunkData;

    public PacketMapChunkBulk(boolean hasSkylight, List<PacketChunkData> chunkData) {
        this.hasSkylight = hasSkylight;
        this.chunkData = chunkData;
    }

    public boolean hasSkylight() {
        return this.hasSkylight;
    }

    public List<PacketChunkData> getChunkData() {
        return this.chunkData;
    }
}
