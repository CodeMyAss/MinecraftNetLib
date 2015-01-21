package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagInt extends NbtTag<Integer> {

    public NbtTagInt() {
        this(0);
    }

    public NbtTagInt(Integer value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_INT;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(32l);
        this.value = dataInput.readInt();
    }
}
