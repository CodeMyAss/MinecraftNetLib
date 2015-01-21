package com.captainbern.minecraft.game.entity.metadata;

public class Metadata<T> {

    private final MetadataType type;
    private int index;
    private T value;

    public Metadata(int index, T value) {
        this.type = MetadataType.getByClass(value.getClass());
        if (type == null)
            throw new RuntimeException("Failed to find a valid MetadataType for: \'" + value.getClass().getName() + "\'!");

        this.index = index;
        this.value = value;
    }

    public MetadataType getType() {
        return this.type;
    }

    public int getIndex() {
        return this.index;
    }

    public T getValue() {
        return this.value;
    }
}
