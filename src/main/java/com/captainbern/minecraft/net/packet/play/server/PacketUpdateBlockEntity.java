package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.nbt.NbtTagCompound;
import com.captainbern.litebot.net.packet.Packet;

public class PacketUpdateBlockEntity implements Packet {

    private int x;
    private int y;
    private int z;
    private byte action;
    private NbtTagCompound tagCompound;

    public PacketUpdateBlockEntity(int x, int y, int z, byte action, NbtTagCompound tagCompound) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.action = action;
        this.tagCompound = tagCompound;
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

    public byte getAction() {
        return this.action;
    }

    public NbtTagCompound getTagCompound() {
        return this.tagCompound;
    }
}
