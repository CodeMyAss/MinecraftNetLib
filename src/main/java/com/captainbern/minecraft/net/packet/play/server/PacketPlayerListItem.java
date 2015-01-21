package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;
import com.captainbern.litebot.util.chat.Message;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

public class PacketPlayerListItem implements Packet {
    
    public static class PlayerListEntry{
        private UUID uuid; // The uuid of the player
        private String name; // String

        private Property[] properties;
        
        private int gameMode;
        private int ping;
        private boolean hasDisplayName;
        private Message displayName;
        
        public PlayerListEntry(UUID uuid){
            this.uuid = uuid;
        }
        
        public PlayerListEntry(UUID uuid, boolean hasDisplayName, Message displayName){
            this.uuid = uuid;
            this.hasDisplayName = hasDisplayName;
            this.displayName = displayName;
        }
        
        public PlayerListEntry(UUID uuid, short gameMode){
            this.uuid = uuid;
            this.gameMode = gameMode;
        }
        
        public PlayerListEntry(UUID uuid, int ping){
            this.uuid = uuid;
            this.ping = ping;
        }
        
        public PlayerListEntry(UUID uuid, String name, Property[] properties, int gameMode, int ping, boolean hasDisplayName, Message displayName){
            this.uuid = uuid;
            this.name = name;
            this.properties = properties;
            this.gameMode = gameMode;
            this.ping = ping;
            this.hasDisplayName = hasDisplayName;
            this.displayName = displayName;
        }

        public UUID getUuid() {
            return this.uuid;
        }

        public String getName() {
            return this.name;
        }

        public Property[] getProperties() {
            return this.properties;
        }

        public int getGameMode() {
            return this.gameMode;
        }

        public int getPing() {
            return this.ping;
        }

        public boolean hasDisplayName() {
            return this.hasDisplayName;
        }

        public Message getDisplayName() {
            return this.displayName;
        }
    }
    
    public static class Property{
        private String name; // String
        private String value;
        private boolean isSigned;
        private String signature; // Only if Is Signed is true
        
        public Property(String name, String value, boolean isSigned, String signature){
            this.name = name;
            this.value = value;
            this.isSigned = isSigned;
            this.signature = signature;
        }
        
        public Property(String name, String value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isSigned() {
            return this.isSigned;
        }

        public String getSignature() {
            return this.signature;
        }
    }

    public static enum ListAction {

        ADD_PLAYER(0),
        UPDATE_GAMEMODE(1),
        UPDATE_LATENCY(2),
        UPDATE_DISLAY_NAME(3),
        REMOVE_PLAYER(4);

        private final int id;

        private static final Map<Integer, ListAction> BY_ID = Maps.newHashMap();
        static {
            for (ListAction listAction : ListAction.values()) {
                BY_ID.put(listAction.getId(), listAction);
            }
        }

        private ListAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static ListAction getById(int id) {
            return BY_ID.get(id);
        }
    }

    private int action;
    private PlayerListEntry[] entries;

    public PacketPlayerListItem(int action, PlayerListEntry[] entries) {
        this.action = action;
        this.entries = entries;
    }
    
    public int getAction(){
        return this.action;
    }
    
    public PlayerListEntry[] getEntries(){
        return this.entries;
    }
}
