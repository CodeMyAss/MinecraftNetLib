package com.captainbern.minecraft.game.chat;

public enum ChatHoverActionType {

    SHOW_TEXT,
    SHOW_ITEM,
    SHOW_ACHIEVEMENT,
    SHOW_ENTITY;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
