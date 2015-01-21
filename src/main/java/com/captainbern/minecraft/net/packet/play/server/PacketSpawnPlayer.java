package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;
import java.util.UUID;

public class PacketSpawnPlayer implements Packet {

    private int entityId;
    private UUID playerUuid;
    private int x;
    private int y;
    private int z;
    private byte yaw;
    private byte pitch;
    private short item;
    private List<Metadata> metadata;

    public PacketSpawnPlayer(int entityId, UUID playerUuid, int x, int y, int z, byte yaw, byte pitch, short item, List<Metadata> metadata) {
        this.entityId = entityId;
        this.playerUuid = playerUuid;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.item = item;
        this.metadata = metadata;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public UUID getPlayerUuid() {
        return this.playerUuid;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public byte getYaw() {
        return this.yaw;
    }

    public byte getPitch() {
        return this.pitch;
    }

    public short getItem() {
        return this.item;
    }

    public List<Metadata> getMetadata() {
        return this.metadata;
    }
}
