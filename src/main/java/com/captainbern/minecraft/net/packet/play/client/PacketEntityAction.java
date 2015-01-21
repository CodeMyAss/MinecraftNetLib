package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketEntityAction implements Packet {

    public static enum Animation {

        CROUCH(0),
        UNCROUCH(1),
        LEAVE_BED(2),
        START_SPRINTING(3),
        STOP_SPRINTING(4),
        JUMP_WITH_HORSE(5),
        OPEN_INVENTORY(6);

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

    private int targetId;
    private int actionId;
    private int jumpBoost;

    public PacketEntityAction(int targetId, int actionId, int jumpBoost) {
        this.targetId = targetId;
        this.actionId = actionId;
        this.jumpBoost = jumpBoost;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public int getActionId() {
        return this.actionId;
    }

    public int getJumpBoost() {
        return this.jumpBoost;
    }
}
