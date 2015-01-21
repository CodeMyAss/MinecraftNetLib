package com.captainbern.minecraft.game.chat;

public class ClickEvent implements Cloneable {

    private ChatClickActionType actionType;
    private String value;

    public ClickEvent(ChatClickActionType type, String value) {
        this.actionType = type;
        this.value = value;
    }

    public ChatClickActionType getActionType() {
        return this.actionType;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public ClickEvent clone() throws CloneNotSupportedException {
        return new ClickEvent(this.actionType, this.value);
    }
}
