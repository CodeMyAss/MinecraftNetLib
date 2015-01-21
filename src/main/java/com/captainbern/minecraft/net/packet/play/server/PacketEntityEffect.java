package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketEntityEffect implements Packet {

    private int entityId;
    private int effectId; // See: http://minecraft.gamepedia.com/Potion_effect#Parameters
    private int amplifier;
    private int duration;
    private boolean hideParticles;

    public PacketEntityEffect(int entityId, int effectId, int amplifier, int duration, boolean hideParticles) {
        this.entityId = entityId;
        this.effectId = effectId;
        this.amplifier = amplifier;
        this.duration = duration;
        this.hideParticles = hideParticles;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getEffectId() {
        return this.effectId;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isHideParticles() {
        return this.hideParticles;
    }
}
