package com.captainbern.minecraft.game.chat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TextMessage extends Message {

    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public JsonElement toJson() {
        JsonElement jsonElement = super.toJson();

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            jsonObject.addProperty("text", this.text);

            return jsonObject;
        }

        return jsonElement;
    }
}
