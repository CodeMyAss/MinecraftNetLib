package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketEntityMetadata implements Packet {

    private int entityId;
    private List<Metadata> metadata;

    public PacketEntityMetadata(int entityId, List<Metadata> metadata) {
        this.entityId = entityId;
        this.metadata = metadata;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public List<Metadata> getMetadata() {
        return this.metadata;
    }
}
