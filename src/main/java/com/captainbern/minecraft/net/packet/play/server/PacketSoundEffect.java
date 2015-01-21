package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

public class PacketSoundEffect implements Packet {

    private String soundName;
    private int effectX;
    private int effectY;
    private int effectZ;
    private float volume;
    private short pitch;

    public PacketSoundEffect(String soundName, int effectX, int effectY, int effectZ, float volume, byte pitch) {
        this.soundName = soundName;
        this.effectX = effectX;
        this.effectY = effectY;
        this.effectZ = effectZ;
        this.volume = volume;
        this.pitch = (short)(pitch & 0xff);
    }
    
    public String getSoundName(){
        return this.soundName;
    }
    
    public int getX(){
        return this.effectX;
    }
    
    public int getY(){
        return this.effectY;
    }
    
    public int getZ(){
        return this.effectZ;
    }
    
    public float getVolume(){
        return this.volume;
    }
    
    public short getPitch(){
        return this.pitch;
    }
}
