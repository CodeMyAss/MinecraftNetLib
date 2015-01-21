package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketUseEntity implements Packet {

    public static enum UseAction {
        INTERACT(0),
        ATTACK(1),
        INTERACT_AT(2);

        private final int id;

        private UseAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

    private int targetId;
    private int useAction;
    private float targetX;
    private float targetY;
    private float targetZ;

    public PacketUseEntity(int targetId, int useAction) {
        if (useAction == UseAction.INTERACT_AT.getId())
            throw new IllegalArgumentException("UseAction.INTERACT_AT also needs xyz coords!");

        this.targetId = targetId;
        this.useAction = useAction;
    }

    public PacketUseEntity(int targetId, int useAction, float x, float y, float z) {
        if (useAction != UseAction.INTERACT_AT.getId())
            throw new IllegalArgumentException("UseAction.INTERACT_AT is the only packet that needs xyz coords!");

        this.targetId = targetId;
        this.useAction = useAction;
        this.targetX = x;
        this.targetY = y;
        this.targetZ = z;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public int getUseAction() {
        return this.useAction;
    }

    public float getTargetX() {
        return this.targetX;
    }

    public float getTargetY() {
        return this.targetY;
    }

    public float getTargetZ() {
        return this.targetZ;
    }
}
