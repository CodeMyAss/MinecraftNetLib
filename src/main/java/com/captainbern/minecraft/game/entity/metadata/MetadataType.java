package com.captainbern.minecraft.game.entity.metadata;

import com.captainbern.litebot.game.Position;
import com.captainbern.litebot.game.Rotation;
import com.captainbern.litebot.inventory.ItemStack;
import com.google.common.collect.Maps;
import com.google.common.primitives.Primitives;

import java.util.Map;

@SuppressWarnings("unchecked")
public enum MetadataType {

    BYTE(0, byte.class),
    SHORT(1, short.class),
    INT(2, int.class),
    FLOAT(3, float.class),
    STRING(4, String.class),
    ITEM(5, ItemStack.class),
    POSITION(6, Position.class),
    ROTATION(7, Rotation.class);

    private final int id;
    private final Class<?> typeClass;

    private static final Map<Integer, MetadataType> BY_ID = Maps.newHashMap();
    private static final Map<Class<?>, MetadataType> BY_CLASS = Maps.newHashMap();
    static {
        for (MetadataType metadataType : MetadataType.values()) {
            BY_ID.put(metadataType.getId(), metadataType);
            BY_CLASS.put(metadataType.getTypeClass(), metadataType);
        }
    }

    private MetadataType(int id, Class<?> typeClass) {
        this.id = id;
        this.typeClass = typeClass;
    }

    public int getId() {
        return this.id;
    }

    public Class<?> getTypeClass() {
        return this.typeClass;
    }

    public static MetadataType getById(int id) {
        return BY_ID.get(id);
    }

    public static MetadataType getByClass(Class typeClass) {
        return BY_CLASS.get(Primitives.unwrap(typeClass));
    }
}
