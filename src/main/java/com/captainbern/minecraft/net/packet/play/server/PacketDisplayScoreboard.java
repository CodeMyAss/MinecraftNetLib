package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.litebot.net.packet.Packet;

public class PacketDisplayScoreboard implements Packet {

    public static enum ScoreboardPosition {

        LIST(0),
        SIDEBAR(1),
        BELOW_NAME(2);

        private final int id;

        private ScoreboardPosition(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

    private int position;
    private String message;

    public PacketDisplayScoreboard(int position, String message) {
        this.position = position;
        this.message = message;
    }

    public int getPosition() {
        return this.position;
    }

    public String getMessage() {
        return this.message;
    }
}
