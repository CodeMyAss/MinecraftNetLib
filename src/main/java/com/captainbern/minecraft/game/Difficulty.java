package com.captainbern.minecraft.game;

import com.google.common.collect.Maps;

import java.util.Map;

public enum Difficulty {

    PEACEFUL(0),
    EASY(1),
    NORMAL(2),
    HARD(3);

    private final int id;

    private static final Map<Integer, Difficulty> BY_ID = Maps.newHashMap();
    static {
        for (Difficulty difficulty : Difficulty.values()) {
            BY_ID.put(difficulty.getId(), difficulty);
        }
    }

    private Difficulty(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static Difficulty getById(int id) {
        return BY_ID.get(id);
    }
}
