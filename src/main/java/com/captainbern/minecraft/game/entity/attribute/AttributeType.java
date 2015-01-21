package com.captainbern.minecraft.game.entity.attribute;

import com.google.common.collect.Maps;

import java.util.Map;

public enum AttributeType {

    MAX_HEALTH("generic.maxHealth", 20, 0, Double.MAX_VALUE),
    FOLLOW_RANGE("generic.followRange", 32, 0, 2048),
    KNOCKBACK_RESISTANCE("generic.knockbackResistance", 0, 0, 1),
    MOVEMENT_SPEED("generic.movementSpeed", 0.699999988079071, 0, Double.MAX_VALUE),
    ATTACK_DAMAGE("generic.attackDamage", 2, 0, Double.MAX_VALUE),
    HORSE_JUMP_STRENGTH("horse.jumpStrength", 0.7, 0, 2),
    ZOMBIE_SPAWN_REINFORCEMENTS_CHANCE("zombie.spawnReinforcements", 0, 0, 1);

    private final String key;
    private final double defaultValue;
    private final double min;
    private final double max;

    private static final Map<String, AttributeType> BY_KEY = Maps.newHashMap();
    static {
        for (AttributeType attributeType : AttributeType.values()) {
            BY_KEY.put(attributeType.getKey(), attributeType);
        }
    }

    private AttributeType(String key, double defaultValue, double min, double max) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
    }

    public String getKey() {
        return this.key;
    }

    public double getDefault() {
        return this.defaultValue;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public static AttributeType getByKey(String key) {
        return BY_KEY.get(key);
    }
}
