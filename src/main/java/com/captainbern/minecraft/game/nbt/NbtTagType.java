package com.captainbern.minecraft.game.nbt;

import com.captainbern.reflection.Reflection;
import com.google.common.collect.Maps;
import com.google.common.primitives.Primitives;

import java.util.List;
import java.util.Map;

public enum NbtTagType {

    TAG_END("TAG_End", 0, Void.class, NbtTagEnd.class),
    TAG_BYTE("TAG_Byte", 1, byte.class, NbtTagByte.class),
    TAG_SHORT("TAG_Short", 2, short.class, NbtTagShort.class),
    TAG_INT("TAG_Int", 3, int.class, NbtTagInt.class),
    TAG_LONG("TAG_Long", 4, long.class, NbtTagLong.class),
    TAG_FLOAT("TAG_Float", 5, float.class, NbtTagFloat.class),
    TAG_DOUBLE("TAG_Double", 6, double.class, NbtTagDouble.class),
    TAG_BYTE_ARRAY("TAG_Byte_Array", 7, byte[].class, NbtTagByteArray.class),
    TAG_STRING("TAG_String", 8, String.class, NbtTagString.class),
    TAG_LIST("TAG_List", 9, List.class, NbtTagList.class),
    TAG_COMPOUND("TAG_Compound", 10, Map.class, NbtTagCompound.class),
    TAG_INT_ARRAY("TAG_Int_Array", 11, int[].class, NbtTagIntArray.class);

    private final String name;
    private final int id;
    private final Class<?> typeClass;
    private final Class<? extends NbtTag> tagClass;

    protected static NbtTagType[] registry;
    protected static Map<Class<?>, NbtTagType> classToTypeRegistry;

    static {
        registry = new NbtTagType[values().length];
        classToTypeRegistry = Maps.newHashMap();

        for (NbtTagType type : values()) {
            registry[type.getId()] = type;

            classToTypeRegistry.put(type.getTypeClass(), type);

            if (type.getTypeClass().isPrimitive()) {
                classToTypeRegistry.put(Primitives.wrap(type.getTypeClass()), type);
            }
        }
    }

    private <V, T extends NbtTag<? extends V>> NbtTagType(String name, int id, Class<V> typeClass, Class<T> tagClass) {
        this.name = name;
        this.id = id;
        this.typeClass = typeClass;
        this.tagClass = tagClass;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Class<?> getTypeClass() {
        return this.typeClass;
    }

    public Class<? extends NbtTag> getTagClass() {
        return this.tagClass;
    }

    public <V, T extends NbtTag<? extends V>> NbtTag<T> newTag() {
        return new Reflection().reflect(this.tagClass).newInstance();
    }

    public static NbtTagType getTypeForId(int id) {
        if (id < 0 || id > registry.length)
            throw new IllegalArgumentException("Invalid NBT-Opcode: " + id);

        return registry[id];
    }

    public static NbtTagType getTypeForClass(Class<?> type) {
        NbtTagType result = classToTypeRegistry.get(type);

        if (result != null) {
            return result;
        }

        throw new RuntimeException("Failed to find a matching NbtTagType for class: " + type.getCanonicalName());
    }
}
