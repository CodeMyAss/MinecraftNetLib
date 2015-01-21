package com.captainbern.minecraft.game;

import com.google.common.collect.Maps;

import java.util.Map;

public enum GameMode {

    SURVIVAL(0),
    CREATIVE(1),
    ADVENTURE(2);

    private final int id;

    private static final Map<Integer, GameMode> BY_ID = Maps.newHashMap();
    static {
        for (GameMode gameMode : GameMode.values()) {
            BY_ID.put(gameMode.getId(), gameMode);
        }
    }

    private GameMode(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static GameMode getById(int id) {
        return BY_ID.get(id);
    }
}
