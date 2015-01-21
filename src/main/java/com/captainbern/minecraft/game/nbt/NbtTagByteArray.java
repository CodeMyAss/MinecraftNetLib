package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagByteArray extends NbtTag<byte[]> {

    public NbtTagByteArray() {
        this(new byte[0]);
    }

    public NbtTagByteArray(byte[] value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_BYTE_ARRAY;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.value.length);
        dataOutput.write(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        int length = dataInput.readInt();
        readLimiter.allocate(8l * length);
        this.value = new byte[length];
        dataInput.readFully(this.value);
    }
}
