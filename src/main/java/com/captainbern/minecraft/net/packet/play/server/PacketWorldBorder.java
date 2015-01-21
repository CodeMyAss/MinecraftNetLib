package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketWorldBorder implements Packet {

    public static enum BorderAction {

        SET_SIZE(0),
        LERP_SIZE(1),
        SET_CENTER(2),
        INITIALIZE(3),
        SET_WARNING_TIME(4),
        SET_WARNING_BLOCKS(5);

        private final int id;

        private static final Map<Integer, BorderAction> BY_ID = Maps.newHashMap();
        static {
            for (BorderAction borderAction : BorderAction.values()) {
                BY_ID.put(borderAction.getId(), borderAction);
            }
        }

        private BorderAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static BorderAction getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int action;

    private double radius;

    private double oldRadius;
    private double newRadius;
    private long speed;

    private double x;
    private double z;

    private int portalTeleportBoundary;
    private int warningTime;
    private int warningBlocks;

    // BorderAction.SET_SIZE;
    public PacketWorldBorder(int action, double radius) {
        this(action, 0, 0, radius, 0, 0, 0, 0, 0, 0);
    }

    // Borderaction.LERP_SIZE
    public PacketWorldBorder(int action, double oldRadius, double newRadius, long speed) {
        this(action, 0, 0, 0, oldRadius, newRadius, speed, 0, 0, 0);
    }

    // BorderAction.SET_CENTER
    public PacketWorldBorder(int action, double x, double z) {
        this(action, x, z, 0, 0, 0, 0, 0, 0, 0);
    }

    // BorderAction.INITIALIZE
    public PacketWorldBorder(int action, double x, double z, double oldRadius, double newRadius, long speed, int portalTeleportBoundary, int warningTime, int warningBlocks) {
        this(action, x, z, 0, oldRadius, newRadius, speed, portalTeleportBoundary, warningTime, warningBlocks);
    }

    // BorderAction.SET_WARNING_TIME - BorderAction.SET_WARNING_BLOCKS
    public PacketWorldBorder(int action, int warningTimeOrBlocks) {
        this(action, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        switch (BorderAction.getById(action)) {
            case SET_WARNING_TIME: {
                this.warningTime = warningTimeOrBlocks;
                this.warningBlocks = 0;
            }
            case SET_WARNING_BLOCKS: {
                this.warningTime = 0;
                this.warningBlocks = warningTimeOrBlocks;
            }
            default: {
                this.warningTime = 0;
                this.warningBlocks = 0;
            }
        }
    }

    public PacketWorldBorder(int action, double x, double z, double radius, double oldRadius, double newRadius, long speed, int portalTeleportBoundary, int warningTime, int warningBlocks) {
        this.action = action;
        this.x = x;
        this.z = z;
        this.radius = radius;
        this.oldRadius = oldRadius;
        this.newRadius = newRadius;
        this.speed = speed;
        this.portalTeleportBoundary = portalTeleportBoundary;
        this.warningTime = warningTime;
        this.warningBlocks = warningBlocks;
    }

    public int getAction() {
        return this.action;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getOldRadius() {
        return this.oldRadius;
    }

    public double getNewRadius() {
        return this.newRadius;
    }

    public long getSpeed() {
        return this.speed;
    }

    public double getX() {
        return this.x;
    }

    public double getZ() {
        return this.z;
    }

    public int getPortalTeleportBoundary() {
        return this.portalTeleportBoundary;
    }

    public int getWarningTime() {
        return this.warningTime;
    }

    public int getWarningBlocks() {
        return this.warningBlocks;
    }
}
