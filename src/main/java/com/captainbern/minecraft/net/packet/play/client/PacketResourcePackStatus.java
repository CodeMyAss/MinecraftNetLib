package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketResourcePackStatus implements Packet {

    public static enum ResourcePackStatus {

        LOADED(0),
        DECLINED(1),
        FAILED_DOWNLOAD(2),
        ACCEPTED(3);

        private final int id;

        private static final Map<Integer, ResourcePackStatus> BY_ID = Maps.newHashMap();
        static {
            for (ResourcePackStatus status : ResourcePackStatus.values()) {
                BY_ID.put(status.getId(), status);
            }
        }

        private ResourcePackStatus(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ResourcePackStatus getById(int id) {
            return BY_ID.get(id);
        }
    }

    private String hash;
    private int status;

    public PacketResourcePackStatus(String hash, int status) {
        this.hash = hash;
        this.status = status;
    }

    public String getHash() {
        return this.hash;
    }

    public int getStatus() {
        return this.status;
    }
}
