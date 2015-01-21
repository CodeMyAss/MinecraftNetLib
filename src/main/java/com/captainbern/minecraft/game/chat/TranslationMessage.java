package com.captainbern.minecraft.game.chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TranslationMessage extends Message {

    private String translateKey;
    private Message[] translationParts;

    public TranslationMessage(String translateKey, Message... translationParts) {
        this.translateKey = translateKey;
        this.translationParts = translationParts;
    }

    @Override
    public String getText() {
        return this.translateKey;
    }

    @Override
    public JsonElement toJson() {
        JsonElement jsonElement = super.toJson();
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            jsonObject.addProperty("translate", this.translateKey);

            JsonArray array = new JsonArray();
            for (Message message : this.translationParts) {
                array.add(message.toJson());
            }

            jsonObject.add("with", array);

            return jsonObject;
        }

        return jsonElement;
    }
}
