package com.captainbern.minecraft.game.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NbtTagCompound extends NbtTag<Map<String, NbtTag<?>>> {

    public NbtTagCompound() {
        this(new HashMap<String, NbtTag<?>>());
    }

    public NbtTagCompound(Map<String, NbtTag<?>> values) {
        super(values);
    }
    
    // All the things!1!1!1!!!

    public boolean containsKey(String key) {
        return this.value.containsKey(key);
    }

    public Set<String> getKeys() {
        return this.value.keySet();
    }

    public <T> NbtTag<T> getValue(String key) {
        return (NbtTag<T>) this.value.get(key);
    }

    public NbtTagCompound putObject(String key, Object value) {
        if (value == null) {
            remove(key);
        } else if (value instanceof NbtTag) {
            put(key, (NbtTag) value);
        } else {
            NbtTag tag = NbtTagType.getTypeForClass(value.getClass()).newTag();
            tag.setValue(value);
            put(key, tag);
        }

        return this;
    }

    public NbtTagCompound put(String key, NbtTag<?> value) {
        this.value.put(key, value);
        return this;
    }

    public byte getByte(String key) {
        return (byte) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, byte value) {
        this.value.put(key, new NbtTagByte(value));
        return this;
    }

    public short getShort(String key) {
        return (short) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, short value) {
        this.value.put(key, new NbtTagShort(value));
        return this;
    }

    public int getInt(String key) {
        return (int) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, int value) {
        this.value.put(key, new NbtTagInt(value));
        return this;
    }

    public long getLong(String key) {
        return (long) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, long value) {
        this.value.put(key, new NbtTagLong(value));
        return this;
    }

    public float getFloat(String key) {
        return (float) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, float value) {
        this.value.put(key, new NbtTagFloat(value));
        return this;
    }

    public double getDouble(String key, double value) {
        return (double) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, double value) {
        this.value.put(key, new NbtTagDouble(value));
        return this;
    }

    public byte[] getByteArray(String key) {
        return (byte[]) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, byte[] value) {
        this.value.put(key, new NbtTagByteArray(value));
        return this;
    }

    public String getString(String key) {
        return (String) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, String value) {
        this.value.put(key, new NbtTagString(value));
        return this;
    }

    public <T extends NbtTag<?>> NbtTagList<T> getList(String key) {
        return (NbtTagList<T>) ((NbtTag) getValue(key));
    }

    public <T extends NbtTag<?>> NbtTagCompound put(String key, NbtTagList<T> value) {
        this.value.put(key, value);
        return this;
    }

    public NbtTagCompound getTagCompound(String key) {
        return (NbtTagCompound) ((NbtTag) getValue(key));
    }

    public NbtTagCompound put(String key, NbtTagCompound value) {
        this.value.put(key, value);
        return this;
    }

    public int[] getIntArray(String key) {
        return (int[]) getValue(key).getValue();
    }

    public NbtTagCompound put(String key, int[] value) {
        this.value.put(key, new NbtTagIntArray(value));
        return this;
    }

    public NbtTag<?> remove(String key) {
        return this.value.remove(key);
    }

    public Iterator<NbtTag<?>> iterator() {
        return this.value.values().iterator();
    }

    @Override
    public NbtTagType getType() {
        return NbtTagType.TAG_COMPOUND;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

        for (String key : this.value.keySet()) {
            NbtTag<?> tag = this.value.get(key);

            dataOutput.writeByte(tag.getType().getId());
            if (tag.getType() != NbtTagType.TAG_END) {
                dataOutput.writeUTF(key);
                tag.write(dataOutput);
            }
        }

        dataOutput.writeByte(NbtTagType.TAG_END.getId());
    }

    @Override
    public void load(DataInput dataInput, int depth, NbtReadLimiter readLimiter) {
        if (depth > 0x200)
            throw new RuntimeException("Tried to load NbtTag with too high complexity, depth = " + depth);

        this.value.clear();

        byte id;

        while ((id = readId(dataInput)) != 0) {
            String key = readKey(dataInput);

            readLimiter.allocate(16l * key.length());
            NbtTag tag = readTag(id, dataInput, depth + 1, readLimiter);

            this.value.put(key, tag);
        }
    }

    private String readKey(DataInput dataInput) {
        try {
            return dataInput.readUTF();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while loading an NbtTag!", e);
        }
    }

    private static byte readId(DataInput dataInput) {
        try {
            return dataInput.readByte();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while loading an NbtTag!", e);
        }
    }

    private static NbtTag readTag(int id, DataInput dataInput, int depth, NbtReadLimiter readLimiter) {
        try {
            NbtTag tag = NbtTagType.getTypeForId(id).newTag();
            tag.load(dataInput, depth, readLimiter);

            return tag;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while loading an NbtTag!", e);
        }
    }
}
