package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketUpdateHealth implements Packet {

    private float health;
    private int food;
    private float foodSaturation;

    public PacketUpdateHealth(float health, int food, float foodSaturation) {
        this.health = health;
        this.food = food;
        this.foodSaturation = foodSaturation;
    }
    
    public float getHealth(){
        return this.health;
    }
    
    public int getFood(){
        return this.food;
    }
    
    public float getFoodSaturation(){
        return this.foodSaturation;
    }
}
