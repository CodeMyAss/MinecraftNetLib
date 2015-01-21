package com.captainbern.minecraft.game.entity.attribute;

import java.util.List;

public class Attribute {

    private AttributeType type;
    private double value;
    private List<AttributeModifier> modifiers;

    public Attribute(String key, double value, List<AttributeModifier> modifiers) {
        this(AttributeType.getByKey(key), value, modifiers);
    }

    public Attribute(AttributeType type, double value, List<AttributeModifier> modifiers) {
        this.type = type;
        this.value = value;
        this.modifiers = modifiers;
    }

    public AttributeType getType() {
        return this.type;
    }

    public double getValue() {
        return this.value;
    }

    public List<AttributeModifier> getModifiers() {
        return this.modifiers;
    }
}
