package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketRespawn implements Packet {

    private int dimension; // -1: The Nether, 0: The Overworld, 1: The End
    private byte difficulty; //UNSIGNED 0 thru 3 for Peaceful, Easy, Normal, Hard.
    private byte gameMode; //UNSIGNED 0: survival, 1: creative, 2: adventure. The hardcore flag is not included
    private String levelType; // Same as Join Game

    public PacketRespawn(int dimension, byte difficulty, byte gameMode, String levelType) {
        this.dimension = dimension;
        this.difficulty = difficulty;
        this.gameMode = gameMode;
        this.levelType = levelType;
    }
    
    public int getDimension(){
        return this.dimension;
    }
    
    public byte getDifficulty(){
        return this.difficulty;
    }
    
    public byte getGameMode(){
        return this.gameMode;
    }
    
    public String getLevelType(){
        return this.levelType;
    }
}
