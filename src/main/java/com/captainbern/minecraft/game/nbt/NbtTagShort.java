package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagShort extends NbtTag<Short> {

    public NbtTagShort() {
        this((short) 0);
    }

    public NbtTagShort(Short value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_SHORT;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(16l);
        this.value = dataInput.readShort();
    }
}
