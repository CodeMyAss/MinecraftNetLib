package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NbtTagList<T> extends NbtTag<List<NbtTag<T>>> {

    private NbtTagType listType;

    public NbtTagList() {
        super(new ArrayList<NbtTag<T>>());
    }

    public NbtTagList(NbtTagType type) {
        super(new ArrayList<NbtTag<T>>());
        this.listType = type;
    }

    public NbtTagList(NbtTagType type, List<NbtTag<T>> value) {
        super(value);

        for (NbtTag tag : value) {
            if (tag.getType() != this.listType)
                throw new IllegalArgumentException("List contains values of an illegal type!");
        }
    }

    public NbtTagType getListType() {
        return this.listType;
    }

    public void setListType(NbtTagType nbtType) {
        this.listType = nbtType;
    }

    public void add(NbtTag<T> nbtTag) {
        this.value.add(nbtTag);
    }

    public void add(byte b) {
        this.add((NbtTag<T>) new NbtTagByte(b));
    }

    public void add(short s) {
        this.add((NbtTag<T>) new NbtTagShort(s));
    }

    public void add(int i) {
        this.add((NbtTag<T>) new NbtTagInt(i));
    }

    public void add(long l) {
        this.add((NbtTag<T>) new NbtTagLong(l));
    }

    public void add(float f) {
        this.add((NbtTag<T>) new NbtTagFloat(f));
    }

    public void add(double d) {
        this.add((NbtTag<T>) new NbtTagDouble(d));
    }

    public void add(byte[] ba) {
        this.add((NbtTag<T>) new NbtTagByteArray(ba));
    }

    public void add(String s) {
        this.add((NbtTag<T>) new NbtTagString(s));
    }

    public void add(int[] ia) {
        this.add((NbtTag<T>) new NbtTagIntArray(ia));
    }

    public void remove(Object value) {
        this.value.remove(value);
    }

    public T getValue(int index) {
        return (T) this.value.get(index);
    }

    public Collection<NbtTag<T>> toCollection() {
        return this.value;
    }

    public int size() {
        return this.value.size();
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_LIST;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.listType.getId());
        dataOutput.writeInt(this.value.size());

        for (NbtTag tag : this.value) {
            tag.write(dataOutput);
        }
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) throws IOException {
        byte type = dataInput.readByte();
        int valueSize = dataInput.readInt();

        this.listType = NbtTagType.getTypeForId(type);
        this.value = new ArrayList<>();

        for (int i = 0; i < valueSize; i++) {
            NbtTag tag = this.listType.newTag();
            tag.load(dataInput, depth + 1, readLimiter);
            this.value.add(tag);
        }
    }
}
