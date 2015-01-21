package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketTabComplete implements Packet {

    private String text;
    private boolean hasPosition;
    private int x;
    private int y;
    private int z;

    public PacketTabComplete(String text) {
        this.text = text;
        this.hasPosition = false;
    }

    public PacketTabComplete(String text, int x, int y, int z) {
        this.text = text;
        this.hasPosition = true;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getText() {
        return this.text;
    }

    public boolean hasPosition() {
        return this.hasPosition;
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
}
