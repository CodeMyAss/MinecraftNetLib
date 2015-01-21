package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketSpawnMob implements Packet {

    /* VarInt EntityID; // Entity's ID
    UnsignedByte Type; // The type of mob. See Mobs
    Int X; // X position as a Fixed-Point number
    Int Y; // Y position as a Fixed-Point number
    Int Z; // Z position as a Fixed-Point number
    Byte Yaw; // The yaw in steps of 2p/256
    Byte Pitch; // The pitch in steps of 2p/256
    Byte HeadPitch; // The pitch in steps of 2p/256
    Short VelocityX;
    Short VelocityY;
    Short VelocityZ;
    Metadata Metadata; */

    private int entityId;
    private short type; // unsigned
    private int x;
    private int y;
    private int z;
    private byte yaw;
    private byte pitch;
    private byte headPitch;
    private short velocityX;
    private short velocityY;
    private short velocityZ;
    private List<Metadata> metadata;

    public PacketSpawnMob(int entityId, short type, int x, int y, int z, byte yaw, byte pitch, byte headPitch, short velocityX, short velocityY, short velocityZ, List<Metadata> metadata) {
        this.entityId = entityId;
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.headPitch = headPitch;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.metadata = metadata;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public short getType() {
        return this.type;
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

    public byte getHeadPitch() {
        return this.headPitch;
    }

    public short getVelocityX() {
        return this.velocityX;
    }

    public short getVelocityY() {
        return this.velocityY;
    }

    public short getVelocityZ() {
        return this.velocityZ;
    }

    public List<Metadata> getMetadata() {
        return this.metadata;
    }
}
