package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketChangeGameState implements Packet {

    public static enum ChangeGameStateReason {

        INVALID_BED(0),
        END_RAIN(1),
        BEGIN_RAIN(2),
        CHANGE_GAMEMODE(3),
        ENTER_CREDITS(4),
        DEMO_MESSAGES(5),
        ARROW_HIT_PLAYER(6),
        FADE_VALUE(7),
        FADE_TIME(8);

        private final int id;

        private static final Map<Integer, ChangeGameStateReason> BY_ID = Maps.newHashMap();
        static {
            for (ChangeGameStateReason reason : ChangeGameStateReason.values()) {
                BY_ID.put(reason.getId(), reason);
            }
        }

        private ChangeGameStateReason(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ChangeGameStateReason getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int reason;
    private float value;

    public PacketChangeGameState(int reason, float value) {
        this.reason = reason;
        this.value = value;
    }

    public int getReason() {
        return this.reason;
    }

    public float getValue() {
        return this.value;
    }
}
