package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

import java.util.UUID;

public class PacketSpectate implements Packet {

    private UUID targetPlayer;

    public PacketSpectate(UUID targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public UUID getTargetPlayer() {
        return this.targetPlayer;
    }
}
