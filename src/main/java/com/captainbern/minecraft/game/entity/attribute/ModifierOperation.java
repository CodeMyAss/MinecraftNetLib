package com.captainbern.minecraft.game.entity.attribute;

import com.google.common.collect.Maps;

import java.util.Map;

public enum ModifierOperation {

    ADD(0),
    ADD_MULTIPLIED(1),
    MULTIPLY(2);

    private final int id;

    private static final Map<Integer, ModifierOperation> BY_ID = Maps.newHashMap();
    static {
        for (ModifierOperation modifierOperation : ModifierOperation.values()) {
            BY_ID.put(modifierOperation.getId(), modifierOperation);
        }
    }

    private ModifierOperation(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ModifierOperation getById(int id) {
        return BY_ID.get(id);
    }
}
