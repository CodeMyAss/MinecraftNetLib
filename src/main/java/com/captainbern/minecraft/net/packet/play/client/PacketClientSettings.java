package com.captainbern.minecraft.net.packet.play.client;

import com.captainbern.litebot.net.packet.Packet;

public class PacketClientSettings implements Packet {

    /**
     * SEE MORE: http://wiki.vg/Protocol#Client_Settings
     *
     * (perhaps a more api-ish thing here)
     */


    private String locale;
    private byte viewDistance;
    private byte chatFlags;
    private boolean chatColours;
    private int skinSettings;

    public PacketClientSettings(String locale, byte viewDistance, byte chatFlags, boolean chatColours, int skinSettings) {
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatFlags = chatFlags;
        this.chatColours = chatColours;
        this.skinSettings = skinSettings;
    }

    public String getLocale() {
        return this.locale;
    }

    public byte getViewDistance() {
        return this.viewDistance;
    }

    public byte getChatFlags() {
        return this.chatFlags;
    }

    public boolean isChatColoursEnabled() {
        return this.chatColours;
    }

    public int getSkinSettings() {
        return this.skinSettings;
    }
}
