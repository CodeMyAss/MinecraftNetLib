package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

/**
 * Special packet: http://wiki.vg/Protocol#Entity
 *
 * All entity related packets are a sub-class of this packet. We will register this
 * packet as part of the server-protocol (in case some third-party server decides
 * to send one)
 */
public class PacketEntity implements Packet {

    private int entityId;

    public PacketEntity(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() {
        return this.entityId;
    }
}
