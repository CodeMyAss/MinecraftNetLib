package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagLong extends NbtTag<Long> {

    public NbtTagLong() {
        this(0l);
    }

    public NbtTagLong(Long value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_LONG;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(64l);
        this.value = dataInput.readLong();
    }
}
