package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketDigging implements Packet {

    public static enum Status {

        STARTED_DIGGING((byte) 0),
        STOPPED_DIGGING((byte) 1),
        FINISHED_DIGGING((byte) 2),
        DROP_ITEMSTACK((byte) 3),
        DROP_ITEM((byte) 4),
        SHOOT_ARROW_OR_FINISH_EATING((byte) 5);

        private final byte id;

        private static final Map<Byte, Status> BY_ID = Maps.newHashMap();
        static {
            for (Status status : Status.values()) {
                BY_ID.put(status.getId(), status);
            }
        }

        private Status(byte id) {
            this.id = id;
        }

        public byte getId() {
            return this.id;
        }

        public static Status getById(byte id) {
            return BY_ID.get(id);
        }
    }

    public static enum Face {
        BOTTOM((byte) 0), // -Y
        TOP((byte) 1),    // +Y

        LEFT((byte) 2),   // -Z
        RIGHT((byte) 3),  // +Z

        FRONT((byte) 4),  // -X
        BACK((byte) 5);   // +X

        private final byte face;

        private static final Map<Byte, Face> BY_ID = Maps.newHashMap();
        static {
            for (Face face : Face.values()) {
                BY_ID.put(face.getFace(), face);
            }
        }

        private Face(byte face) {
            this.face = face;
        }

        public byte getFace() {
            return this.face;
        }

        public static Face getById(byte id) {
            return BY_ID.get(id);
        }
    }

    private int status;
    private int x;
    private int y;
    private int z;
    private byte face;

    public PacketDigging(int status, int x, int y, int z, byte face) {
        this.status = status;
        this.x = x;
        this.y = y;
        this.z = z;
        this.face = face;
    }

    public int getStatus() {
        return this.status;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public byte getFace() {
        return this.face;
    }
}
