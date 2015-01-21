package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagFloat extends NbtTag<Float> {

    public NbtTagFloat() {
        this((float) 0);
    }

    public NbtTagFloat(Float value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_FLOAT;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(32l);
        this.value = dataInput.readFloat();
    }
}
