package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketEntityStatus implements Packet {

    public static enum EntityStatus {
        
        LIVING_UNDETERMINED(0),
        PLAYER_UNDETERMINED(1),
        ENTITY_HURT(2),
        ENTITY_DEAD(3),
        ENTITY_GOLEM_ARMS_UP(4),
        /*There is no 5 */
        ENTITY_TAMING(6),
        ENTITY_TAMED(7),
        ENTITY_WOLF_SHAKE(8),
        PLAYER_EAT_ACCEPTED(9),
        SHEEP_IGNITE_TNT_EAT(10),
        ENTITY_GOLEM_HANDING_ROSE(11),
        ENTITY_VILLAGER_MATING(12),
        ENTITY_VILLAGER_ANGRY(13),
        ENTITY_VILLAGER_HAPPY(14),
        ENTITY_WITCH_MAGIC(15),
        ENTITY_ZOMBIE_CONVERSION(16),
        FIREWORK_EXPLODE(17),
        ENTITY_MATING(18),
        ENTITY_SQUID_REORIENT(19),
        ENTITY_EXPLOSION_PARTICLES(20),
        ENTITY_GUARDIAN_SOUND(21),
        PLAYER_ENABLE_REDUCED_DEBUG(22),
        PLAYER_DISABLE_REDUCED_DEBUG(23);
        
        private final int id;
        
        private static final Map<Integer, EntityStatus> BY_ID = Maps.newHashMap();
        static {
            for (EntityStatus combatEvent : EntityStatus.values()) {
                BY_ID.put(combatEvent.getId(), combatEvent);
            }
        }
        
        private EntityStatus(int id) {
            this.id = (byte)id;
        }
        
        public int getId() {
            return this.id;
        }
        
        public static EntityStatus getById(byte id) {
            return BY_ID.get(id);
        }
        
    }
    
    private int entityId;
    private int status;

    public PacketEntityStatus(int entityId, int status) {
        this.entityId = entityId;
        this.status = status;
    }
    
    public int getEntityId(){
        return this.entityId;
    }
    
    public int getEntityStatus(){
        return this.status;
    }
}
