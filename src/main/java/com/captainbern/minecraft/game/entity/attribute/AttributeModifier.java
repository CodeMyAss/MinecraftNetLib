package com.captainbern.minecraft.game.entity.attribute;

import java.util.UUID;

public class AttributeModifier {

    private UUID type;
    private double amount;
    private ModifierOperation operation;

    public AttributeModifier(UUID type, double amount, byte operation) {
        this(type, amount, ModifierOperation.getById(operation));
    }

    public AttributeModifier(UUID type, double amount, ModifierOperation operation) {
        this.type = type;
        this.amount = amount;
        this.operation = operation;
    }

    public UUID getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public ModifierOperation getOperation() {
        return this.operation;
    }
}
