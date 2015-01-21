package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.packet.Packet;

public class PacketPlaceBlock implements Packet {

    private int x;
    private int y;
    private int z;
    private byte direction;
    private ItemStack item;
    private byte cursorX;
    private byte cursorY;
    private byte cursorZ;

    public PacketPlaceBlock(int x, int y, int z, byte direction, ItemStack item, byte cursorX, byte cursorY, byte cursorZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.item = item;
        this.cursorX = cursorX;
        this.cursorY = cursorY;
        this.cursorZ = cursorZ;
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

    public byte getDirection() {
        return this.direction;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public byte getCursorX() {
        return this.cursorX;
    }

    public byte getCursorY() {
        return this.cursorY;
    }

    public byte getCursorZ() {
        return this.cursorZ;
    }
}
