package com.captainbern.minecraft.game.chat;

public class HoverEvent implements Cloneable {

    private ChatHoverActionType actionType;
    private Message value;

    public HoverEvent(ChatHoverActionType actionType, Message message) {
        this.actionType = actionType;
        this.value = message;
    }

    public ChatHoverActionType getActionType() {
        return this.actionType;
    }

    public Message getValue() {
        return this.value;
    }

    @Override
    public HoverEvent clone() throws CloneNotSupportedException {
        return new HoverEvent(this.actionType, this.value);
    }
}
