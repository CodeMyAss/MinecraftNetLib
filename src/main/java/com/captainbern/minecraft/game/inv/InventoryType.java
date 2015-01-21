package com.captainbern.minecraft.game.inv;

import com.google.common.collect.Maps;

import java.util.Map;

public enum InventoryType {

    CHEST(0),
    WORKBENCH(1),
    FURNACE(2),
    DISPENSER(3),
    ENCHANTMENT_TABLE(4),
    BREWING_STAND(5),
    VILLAGER_TRADE_PROMPT(6),
    BEACON(7),
    ANVIL(8),
    HOPPER(9),
    DROPPER(10),
    HORSE(11);

    private final int id;

    private static final Map<Integer, InventoryType> BY_ID = Maps.newHashMap();
    static {
        for (InventoryType inventoryType : InventoryType.values()) {
            BY_ID.put(inventoryType.getId(), inventoryType);
        }
    }

    private InventoryType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static InventoryType getById(int id) {
        return BY_ID.get(id);
    }
}
