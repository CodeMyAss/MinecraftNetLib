package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NbtTagString extends NbtTag<String> {

    public NbtTagString() {
        this("");
    }

    public NbtTagString(String value) {
        super(value);
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_STRING;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.value);
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        this.value = dataInput.readUTF();
        readLimiter.allocate(16 * this.value.length());
    }
}
