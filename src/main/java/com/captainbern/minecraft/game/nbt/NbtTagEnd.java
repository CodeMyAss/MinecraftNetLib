package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;

public class NbtTagEnd extends NbtTag<Void> {

    public NbtTagEnd() {}

    @Override
    public Void getValue() {
        throw new RuntimeException("TAG_End does not have a value!");
    }

    @Override
    public void setValue(Void value) {
        throw new RuntimeException("TAG_End does not have a value!");
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_END;
    }

    @Override
    public void write(DataOutput dataOutput) {}

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) {}
}
