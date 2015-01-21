package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.game.chat.Message;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketServerChatMessage implements Packet {

    public static enum ChatPosition {

        CHAT(0),
        SYSTEM_MESSAGE(1),
        ABOVE_ACTION_BAR(2);

        private final int id;

        private static final Map<Integer, ChatPosition> BY_ID = Maps.newHashMap();
        static {
            for (ChatPosition chatPosition : ChatPosition.values()) {
                BY_ID.put(chatPosition.getId(), chatPosition);
            }
        }

        private ChatPosition(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ChatPosition getById(int id) {
            return BY_ID.get(id);
        }
    }

    private Message message;
    private byte position;

    public PacketServerChatMessage(Message message, byte position) {
        this.message = message;
        this.position = position;
    }

    public Message getMessage() {
        return this.message;
    }

    public byte getPosition() {
        return this.position;
    }
}
