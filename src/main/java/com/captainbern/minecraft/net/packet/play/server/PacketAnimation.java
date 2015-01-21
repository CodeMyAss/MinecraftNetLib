package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketAnimation implements Packet {

    public static enum Animation {

        SWING_ARM(0),
        HURT(1),
        LEAVE_BED(2),
        EAT_FOOD(3),
        CRITICAL_EFFECT(4),
        MAGIC_CRITICAL_EFFECT(5),
        UNKNOWN(102),
        CROUCH(104),
        UNCROUCH(105);

        private final int id;

        private static final Map<Integer, Animation> BY_ID = Maps.newHashMap();
        static {
            for (Animation animation : Animation.values()) {
                BY_ID.put(animation.getId(), animation);
            }
        }

        private Animation(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static Animation getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int entityId;
    private int animation;

    public PacketAnimation(int entityId, int animation) {
        this.entityId = entityId;
        this.animation = animation;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getAnimation() {
        return this.animation;
    }
}
