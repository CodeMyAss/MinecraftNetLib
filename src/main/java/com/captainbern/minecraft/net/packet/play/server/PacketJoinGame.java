package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketJoinGame implements Packet {

    private int entityId;
    private int gameMode;
    private int dimension;
    private int difficulty;
    private int maxPlayers;
    private String levelType;
    private boolean reducedDebugInfo;

    public PacketJoinGame(int entityId, int gameMode, int dimension, int difficulty, int maxPlayers, String levelType, boolean reducedDebugInfo) {
        this.entityId = entityId;
        this.gameMode = gameMode;
        this.dimension = dimension;
        this.difficulty = difficulty;
        this.maxPlayers = maxPlayers;
        this.levelType = levelType;
        this.reducedDebugInfo = reducedDebugInfo;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public String getLevelType() {
        return this.levelType;
    }

    public boolean isReducedDebugInfo() {
        return this.reducedDebugInfo;
    }
}
