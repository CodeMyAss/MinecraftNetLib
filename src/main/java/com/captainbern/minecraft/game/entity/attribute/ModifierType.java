package com.captainbern.minecraft.game.entity.attribute;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

public enum ModifierType {

    CREATURE_FLEE_SPEED_BONUS(UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A")),
    ENDERMAN_ATTACK_SPEED_BOOST(UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0")),
    SPRINT_SPEED_BOOST(UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D")),
    PIGZOMBIE_ATTACK_SPEED_BOOST(UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718")),
    WITCH_DRINKING_SPEED_PENALTY(UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E")),
    ZOMBIE_BABY_SPEED_BOOST(UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836")),
    ITEM_MODIFIER(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF")),
    SPEED_POTION_MODIFIER(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635")),
    HEALTH_BOOST_POTION_MODIFIER(UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC")),
    SLOW_POTION_MODIFIER(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160890")),
    STRENGTH_POTION_MODIFIER(UUID.fromString("648D7064-6A60-4F59-8ABE-C2C23A6DD7A9")),
    WEAKNESS_POTION_MODIFIER(UUID.fromString("22653B89-116E-49DC-9B6B-9971489B5BE5"));

    private final UUID uuid;

    private static final Map<UUID, ModifierType> BY_UUID = Maps.newHashMap();
    static {
        for (ModifierType modifierType : ModifierType.values()) {
            BY_UUID.put(modifierType.getUuid(), modifierType);
        }
    }

    private ModifierType(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public static ModifierType getByUuid(UUID uuid) {
        return BY_UUID.get(uuid);
    }
}
