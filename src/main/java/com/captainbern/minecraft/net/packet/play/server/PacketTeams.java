package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class PacketTeams implements Packet {

    public static enum TeamAction {

        CREATE(0),
        REMOVE(1),
        UPDATE_INFO(2),
        ADD_PLAYERS(3),
        REMOVE_PLAYERS(4);

        private final int id;

        private static final Map<Integer, TeamAction> BY_ID = Maps.newHashMap();
        static {
            for (TeamAction teamAction : TeamAction.values()) {
                BY_ID.put(teamAction.getId(), teamAction);
            }
        }

        private TeamAction(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static TeamAction getById(int id) {
            return BY_ID.get(id);
        }
    }

    private String teamName;
    private byte mode;
    private String teamDisplayName;
    private String teamPrefix;
    private String teamSuffix;
    private byte friendlyFire;
    private String nameTagVisibility;
    private byte color;
    private String[] players;

    // REMOVE
    public PacketTeams(String teamName, byte mode) {
        this(teamName, mode, null, null, null, (byte) 0, null, (byte) 0, null);
    }

    // CREATE - UPDATE_INFO
    public PacketTeams(String teamName, byte mode, String teamDisplayName, String teamPrefix, String teamSuffix, byte friendlyFire, String nameTagVisibility, byte color) {
        this(teamName, mode, teamDisplayName, teamPrefix, teamSuffix, friendlyFire, nameTagVisibility, color, null);
    }

    // ADD_PLAYER - REMOVE_PLAYER
    public PacketTeams(String teamName, byte mode, String[] players) {
        this(teamName, mode, null, null, null, (byte) 0, null, (byte) 0, players);
    }

    // CREATE
    public PacketTeams(String teamName, byte mode, String teamDisplayName, String teamPrefix, String teamSuffix, byte friendlyFire, String nameTagVisibility, byte color, String[] players) {
        this.teamName = teamName;
        this.mode = mode;
        this.teamDisplayName = teamDisplayName;
        this.teamPrefix = teamPrefix;
        this.teamSuffix = teamSuffix;
        this.friendlyFire = friendlyFire;
        this.nameTagVisibility = nameTagVisibility;
        this.color = color;
        this.players = players;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public byte getMode() {
        return this.mode;
    }

    public String getTeamDisplayName() {
        return this.teamDisplayName;
    }

    public String getTeamPrefix() {
        return this.teamPrefix;
    }

    public String getTeamSuffix() {
        return this.teamSuffix;
    }

    public byte getFriendlyFire() {
        return this.friendlyFire;
    }

    public String getNameTagVisibility() {
        return this.nameTagVisibility;
    }

    public byte getColor() {
        return this.color;
    }

    public String[] getPlayers() {
        return this.players;
    }
}
