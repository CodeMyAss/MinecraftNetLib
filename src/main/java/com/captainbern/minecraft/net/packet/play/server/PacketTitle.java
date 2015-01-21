package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketTitle implements Packet {

    public static enum TitleAction {

        TITLE(0),
        SUBTITLE(1),
        TIMES(2),
        CLEAR(3),
        RESET(4);

        private final int id;

        private static final Map<Integer, TitleAction> BY_ID = Maps.newHashMap();
        static {
            for (TitleAction action : TitleAction.values()) {
                BY_ID.put(action.getId(), action);
            }
        }

        private TitleAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static TitleAction getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int actionId;
    private Message message;
    private int fadeIn;
    private int stay;
    private int fadeOut;

    // TITLE - SUBTITLE
    public PacketTitle(int actionId, Message message) {
        this(actionId, message, 0, 0, 0);
    }

    // TIMES
    public PacketTitle(int actionId, int fadeIn, int stay, int fadeOut) {
        this(actionId, null, fadeIn, stay, fadeOut);
    }

    // CLEAR - RESET
    public PacketTitle(int actionId) {
        this(actionId, null, 0, 0, 0);
    }

    public PacketTitle(int actionId, Message message, int fadeIn, int stay, int fadeOut) {
        this.actionId = actionId;
        this.message = message;
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public int getAction() {
        return this.actionId;
    }

    public Message getMessage() {
        return this.message;
    }

    public int getFadeIn() {
        return this.fadeIn;
    }

    public int getStay() {
        return this.stay;
    }

    public int getFadeOut() {
        return this.fadeOut;
    }
}
