package com.captainbern.minecraft.net.protocol;

public enum Side {

    SERVER,
    CLIENT;

    public Side opposite() {
        return this == CLIENT ? SERVER : CLIENT;
    }
}
