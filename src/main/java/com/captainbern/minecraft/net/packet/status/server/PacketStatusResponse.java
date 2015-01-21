package com.captainbern.minecraft.net.packet.status.server;

import com.captainbern.minecraft.net.packet.AsyncablePacket;
import com.google.gson.JsonObject;

public class PacketStatusResponse implements AsyncablePacket {

    private JsonObject jsonObject;

    public PacketStatusResponse(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject getJsonObject() {
        return this.jsonObject;
    }

    @Override
    public boolean isAsynchronous() {
        return true;
    }
}
