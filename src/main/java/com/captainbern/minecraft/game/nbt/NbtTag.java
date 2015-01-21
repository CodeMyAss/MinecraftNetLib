package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NbtTag<T> {

    protected T value;

    protected NbtTag() {}

    protected NbtTag(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract NbtTagType getType();

    public abstract void write(DataOutput dataOutput) throws IOException;

    public abstract void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException;

    @Override
    public String toString() {
        return this.getType().getName() + "{value=" + this.getValue() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + this.getValue().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof NbtTag))
            return false;

        if (other == this)
            return true;

        NbtTag otherNbt = ((NbtTag) other);

        return otherNbt.getType() == this.getType() && ((NbtTag) other).getValue().equals(this.getValue());
    }
}
