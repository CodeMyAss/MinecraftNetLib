package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagIntArray extends NbtTag<int[]> {

    public NbtTagIntArray() {
        this(new int[0]);
    }

    public NbtTagIntArray(int[] value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_INT_ARRAY;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        for (int i : this.value) {
            dataOutput.writeInt(i);
        }
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        int length = dataInput.readInt();
        readLimiter.allocate(32l * length);
        this.value = new int[length];
        for (int i = 0; i < length; i++) {
            this.value[i] = dataInput.readInt();
        }
    }
}

