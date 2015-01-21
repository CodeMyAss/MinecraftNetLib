package com.captainbern.minecraft.game;

import com.captainbern.minecraft.game.nbt.NbtTagCompound;

public class ItemStack {

    private int id;
    private int amount;
    private int data;
    private NbtTagCompound tagCompound;

    public ItemStack(int id) {
        this(id, 1);
    }

    public ItemStack(int id, int amount) {
        this(id, amount, 0);
    }

    public ItemStack(int id, int amount, int data) {
        this(id, amount, data, null);
    }

    public ItemStack(int id, int amount, int data, NbtTagCompound tagCompound) {
        this.id = id;
        this.amount = amount;
        this.data = data;
        this.tagCompound = tagCompound;
    }

    public int getId() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getData() {
        return this.data;
    }

    public NbtTagCompound getTagCompound() {
        return this.tagCompound;
    }
}
