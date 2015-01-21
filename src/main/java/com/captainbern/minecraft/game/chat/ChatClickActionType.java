package com.captainbern.minecraft.game.chat;

public enum ChatClickActionType {

    NONE,
    OPEN_URL,
    OPEN_FILE,
    RUN_COMMAND,
    SUGGEST_COMMAND;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
