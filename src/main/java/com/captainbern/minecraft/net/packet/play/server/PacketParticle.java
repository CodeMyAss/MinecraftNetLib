package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketParticle implements Packet {

    public static enum ParticleType {
        EXPLOSION(0),
        EXPLOSION_LARGE(1),
        EXPLOSION_HUGE(2),
        FIREWORK_SPARK(3),
        BUBBLE(4),
        WAKE(5),
        SPLASH(6),
        SUSPENDED(7),
        TOWN_AURA(8),
        CRIT(9),
        CRIT_MAGIC(10),
        SMOKE(11),
        SMOKE_LARGE(12),
        SPELL_MOB(13),
        SPELL_INSTANT(14),
        SPELL(15),
        WITCH_MAGIC(17),
        DRIP_WATER(18),
        DRIP_LAVA(19),
        VILLAGER_ANGRY(20),
        VILLAGER_HAPPY(21),
        SUSPEND_DEPTH(22),
        NOTE(23),
        PORTAL(24),
        ENCHANTMENT_TABLE(25),
        FLAME(26),
        LAVA(27),
        FOOTSTEP(28),
        CLOUD(29),
        RED_DUST(30),
        SNOW_BALL(31),
        SNOW_SHOVEL( 32),
        SLIME(33),
        HEART(34),
        BARRIER(35);

        private final int id;

        private static final Map<Integer, ParticleType> BY_ID = Maps.newHashMap();
        static {
            for (ParticleType particleType : ParticleType.values()) {
                BY_ID.put(particleType.getId(), particleType);
            }
        }

        private ParticleType(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ParticleType getById(int id) {
            return BY_ID.get(id);
        }
    }
    
    int particleType;
    boolean longDistance; // If true, particle distance increases from 256 to 65536.
    float x; // X position of the particle
    float y; // Y position of the particle
    float z; // Z position of the particle
    float offsetX; // This is added to the X position after being multiplied by random.nextGaussian()
    float offsetY; // This is added to the Y position after being multiplied by random.nextGaussian()
    float offsetZ; // This is added to the Z position after being multiplied by random.nextGaussian()
    float particleData; // The data of each particle
    int particleCount; // The number of particles to create
    int data[]; // Length depends on particle. ICON_CRACK, BLOCK_CRACK, and BLOCK_DUST have lengths of 2, the rest have 0.

    public PacketParticle(int particleType,boolean longDistance,float x,float y,float z,float offsetX,float offsetY,float offsetZ,float particleData,int particleCount,int[] data) {
        this.particleType = particleType;
        this.longDistance = longDistance;
        this.x = x;
        this.y = y;
        this.z = z;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.particleData = particleData;
        this.particleCount = particleCount;
        this.data = data;
    }

    public int getParticleType() {
        return particleType;
    }

    public boolean isLongDistance() {
        return longDistance;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public float getOffsetZ() {
        return offsetZ;
    }

    public float getParticleData() {
        return particleData;
    }

    public int getParticleCount() {
        return particleCount;
    }

    public int[] getData() {
        return data;
    }
}
