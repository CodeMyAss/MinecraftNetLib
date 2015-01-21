package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagDouble extends NbtTag<Double> {

    public NbtTagDouble() {
        this(0.0);
    }

    public NbtTagDouble(Double value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_DOUBLE;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(64l);
        this.value = dataInput.readDouble();
    }
}
