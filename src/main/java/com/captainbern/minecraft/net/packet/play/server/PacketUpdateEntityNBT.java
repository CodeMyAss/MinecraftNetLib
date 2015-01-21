package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.nbt.NbtTagCompound;
import com.captainbern.minecraft.net.packet.Packet;

public class PacketUpdateEntityNBT implements Packet {

    private int entityId;
    private NbtTagCompound nbtTagCompound;

    public PacketUpdateEntityNBT(int entityId, NbtTagCompound tagCompound) {
        this.entityId = entityId;
        this.nbtTagCompound = tagCompound;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public NbtTagCompound getNbtTagCompound() {
        return this.nbtTagCompound;
    }
}
