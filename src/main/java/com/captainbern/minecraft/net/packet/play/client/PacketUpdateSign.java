package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.game.chat.TextMessage;

public class PacketUpdateSign implements Packet {

    private int x;
    private int y;
    private int z;

    private TextMessage[] lines;

    public PacketUpdateSign(int x, int y, int z, TextMessage[] lines) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.lines = lines;
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

    public TextMessage[] getLines() {
        return this.lines;
    }
}
