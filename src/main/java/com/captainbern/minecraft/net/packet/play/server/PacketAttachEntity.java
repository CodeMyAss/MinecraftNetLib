package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketAttachEntity implements Packet {

    private int entityId;
    private int vehicleId;
    private boolean leash;

    public PacketAttachEntity(int entityId, int vehicleId, boolean leash) {
        this.entityId = entityId;
        this.vehicleId = vehicleId;
        this.leash = leash;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public boolean isLeash() {
        return this.leash;
    }
}
