package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketCombatEvent implements Packet {

    public static enum CombatEvent {

        ENTER_COMBAT(0),
        END_COMBAT(1),
        ENTITY_DEAD(2);

        private final int id;

        private static final Map<Integer, CombatEvent> BY_ID = Maps.newHashMap();
        static {
            for (CombatEvent combatEvent : CombatEvent.values()) {
                BY_ID.put(combatEvent.getId(), combatEvent);
            }
        }

        private CombatEvent(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static CombatEvent getById(int id) {
            return BY_ID.get(id);
        }
    }

    private CombatEvent combatEvent;
    private int duration;
    private int playerId;
    private int entityId;
    private String message;

    public PacketCombatEvent(CombatEvent combatEvent) {
        this(combatEvent, 0, 0, 0, null);
    }

    public PacketCombatEvent(CombatEvent combatEvent, int duration, int entityId) {
        this(combatEvent, duration, 0, entityId, null);
    }

    public PacketCombatEvent(CombatEvent combatEvent, int playerId, int entityId, String message) {
        this(combatEvent, 0, playerId, entityId, message);
    }

    public PacketCombatEvent(CombatEvent combatEvent, int duration, int playerId, int entityId, String message) {
        this.combatEvent = combatEvent;
        this.duration = duration;
        this.playerId = playerId;
        this.entityId = entityId;
        this.message = message;
    }

    public CombatEvent getCombatEvent() {
        return this.combatEvent;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public String getMessage() {
        return this.message;
    }
}
