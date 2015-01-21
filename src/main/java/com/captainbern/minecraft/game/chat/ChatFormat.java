package com.captainbern.minecraft.game.chat;

public enum ChatFormat {

    BOLD,
    ITALIC,
    UNDERLINED,
    STRIKETHROUGH,
    OBFUSCATED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
