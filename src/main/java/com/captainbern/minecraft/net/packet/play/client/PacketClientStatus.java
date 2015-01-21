package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketClientStatus implements Packet {

    public static enum ClientAction {

        PERFORM_RESPAWN(0),
        REQUEST_STATS(1),
        OPEN_INVENTORY_ACHIEVEMENT(2);

        private final int id;

        private static final Map<Integer, ClientAction> BY_ID = Maps.newHashMap();
        static {
            for (ClientAction action : ClientAction.values()) {
                BY_ID.put(action.getId(), action);
            }
        }

        private ClientAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ClientAction getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int actionId;

    public PacketClientStatus(int actionId) {
        this.actionId = actionId;
    }

    public int getActionId() {
        return this.actionId;
    }
}
