package com.captainbern.minecraft.net.protocol;

import com.google.common.collect.Maps;

import java.util.Map;

public enum ProtocolState {

    HANDSHAKE(0),
    STATUS(1),
    LOGIN(2),
    PLAY(3);

    private final int id;

    private static final Map<Integer, ProtocolState> BY_ID = Maps.newHashMap();
    static {
        for (ProtocolState protocolState : ProtocolState.values()) {
            if (BY_ID.containsKey(protocolState.getId()))
                throw new IllegalStateException("ProtocolState: " + protocolState.name() + " appears to be registered twice!");
            BY_ID.put(protocolState.getId(), protocolState);
        }
    }

    private ProtocolState(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ProtocolState getById(int id) {
        return BY_ID.get(id);
    }
}
