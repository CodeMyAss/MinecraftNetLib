package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.entity.attribute.Attribute;
import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketEntityProperties implements Packet {

    private int entityId;
    private List<Attribute> attributes;

    public PacketEntityProperties(int entityId, List<Attribute> attributes) {
        this.entityId = entityId;
        this.attributes = attributes;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public List<Attribute> getAttributes() {
        return this.attributes;
    }
}
