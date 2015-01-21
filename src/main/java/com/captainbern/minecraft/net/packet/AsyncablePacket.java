package com.captainbern.minecraft.net.packet;

public interface AsyncablePacket extends Packet {

    public boolean isAsynchronous();
}
