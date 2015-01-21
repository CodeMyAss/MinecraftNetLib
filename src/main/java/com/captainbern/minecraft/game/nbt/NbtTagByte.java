package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagByte extends NbtTag<Byte> {

    public NbtTagByte() {
        this((byte) 0);
    }

    public NbtTagByte(Byte value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_BYTE;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        readLimiter.allocate(8l);
        this.value = dataInput.readByte();
    }
}
