package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketScoreboardObjective implements Packet {

    public static enum ObjectiveMode {

        CREATE(0),
        REMOVE(1),
        UPDATE_DISPLAY_TEXT(2);

        private final int id;

        private static final Map<Integer, ObjectiveMode> BY_ID = Maps.newHashMap();
        static {
            for (ObjectiveMode mode : ObjectiveMode.values()) {
                BY_ID.put(mode.getId(), mode);
            }
        }

        private ObjectiveMode(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ObjectiveMode getById(int id) {
            return BY_ID.get(id);
        }
    }

    private String objectiveName;
    private byte mode;
    private String value;
    private String type;

    public PacketScoreboardObjective(String objectiveName, byte mode) {
        this(objectiveName, mode, null, null);
    }

    public PacketScoreboardObjective(String objectiveName, byte mode, String value, String type) {
        this.objectiveName = objectiveName;
        this.mode = mode;
        this.value = value;
        this.type = type;
    }

    public String getObjectiveName() {
        return this.objectiveName;
    }

    public byte getMode() {
        return this.mode;
    }

    public String getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }
}
