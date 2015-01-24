package com.captainbern.minecraft.game.chat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ScoreMessage extends Message {

    private String playerName;
    private String objectiveName;

    public ScoreMessage(String playerName, String objectiveName) {
        this.playerName = playerName;
        this.objectiveName = objectiveName;
    }

    @Override
    public String getText() {
        return this.objectiveName + ": " + this.playerName;
    }

    @Override
    public JsonElement toJson() {
        JsonElement jsonElement = super.toJson();
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonObject scoreObject = new JsonObject();
            scoreObject.addProperty("name", this.playerName);
            scoreObject.addProperty("objective", this.objectiveName);

            jsonObject.add("score", scoreObject);

            return jsonObject;
        }

        return jsonElement;
    }
}
