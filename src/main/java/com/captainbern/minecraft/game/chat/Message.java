package com.captainbern.minecraft.game.chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public abstract class Message {

    private ChatColor chatColor = ChatColor.WHITE;
    private List<ChatFormat> chatFormatList = new ArrayList<>();
    private ClickEvent clickEvent;
    private HoverEvent hoverEvent;
    private String insertion;

    private List<Message> extraMessages = new ArrayList<>();

    public abstract String getText();

    public ChatColor getChatColor() {
        return this.chatColor;
    }

    public void setChatColor(ChatColor chatColor) {
        this.chatColor = chatColor;
    }

    public List<ChatFormat> getChatFormatList() {
        return this.chatFormatList;
    }

    public void setChatFormatList(List<ChatFormat> chatFormatList) {
        this.chatFormatList = chatFormatList;
    }

    public void addChatFormat(ChatFormat chatFormat) {
        this.chatFormatList.add(chatFormat);
    }

    public void removeChatFormat(ChatFormat chatFormat) {
        this.chatFormatList.remove(chatFormat);
    }

    public ClickEvent getClickEvent() {
        return this.clickEvent;
    }

    public void setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }

    public HoverEvent getHoverEvent() {
        return this.hoverEvent;
    }

    public void setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
    }

    public String getInsertion() {
        return this.insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public List<Message> getExtraMessages() {
        return this.extraMessages;
    }

    public void setExtraMessages(List<Message> extraMessages) {
        this.extraMessages = extraMessages;
    }

    public void addExtraMessage(Message message) {
        this.extraMessages.add(message);
    }

    public void removeExtraMessage(Message message) {
        this.extraMessages.remove(message);
    }

    public static Message fromJsonString(String jsonString) {
        return fromJsonElement(new JsonParser().parse(jsonString));
    }

    public static Message fromJsonElement(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive()) {
            return new TextMessage(jsonElement.getAsString());
        } else if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            Message message = null;

            if (jsonObject.has("text")) {
                message = new TextMessage(jsonObject.get("text").getAsString());
            } else if (jsonObject.has("translate")) {
                Message[] parts = new Message[0];

                if (jsonObject.has("with")) {
                    JsonArray partsArray = jsonObject.getAsJsonArray("with");
                    parts = new Message[partsArray.size()];
                    for (int i = 0; i < partsArray.size(); i++) {
                        JsonElement element = partsArray.get(i);

                        if (element.isJsonPrimitive())
                            parts[i] = new TextMessage(element.getAsString());
                        else
                            parts[i] = Message.fromJsonElement(element);
                    }
                }

                message = new TranslationMessage(jsonObject.get("translate").getAsString(), parts);
            } else if (jsonObject.has("score")) {
                JsonObject score = jsonObject.getAsJsonObject("score");
                message = new ScoreMessage(score.get("namee").getAsString(), score.get("objective").getAsString());
            }

            if (jsonObject.has("color"))
                message.setChatColor(ChatColor.valueOf(jsonObject.get("color").getAsString().toUpperCase()));

            if (jsonObject.has("clickEvent")) {
                JsonObject clickEvent = jsonObject.getAsJsonObject("clickEvent");
                message.setClickEvent(new ClickEvent(ChatClickActionType.valueOf(clickEvent.get("action").getAsString().toUpperCase()), clickEvent.get("value").getAsString()));
            }

            if (jsonObject.has("hoverEvent")) {
                JsonObject hoverObject = jsonObject.getAsJsonObject("hoverEvent");
                message.setHoverEvent(new HoverEvent(ChatHoverActionType.valueOf(hoverObject.get("action").getAsString().toUpperCase()), Message.fromJsonElement(hoverObject.get("value"))));
            }

            for (ChatFormat format : ChatFormat.values()) {
                if (jsonObject.has(format.toString()) && jsonObject.get(format.toString()).getAsBoolean())
                    message.addChatFormat(format);
            }

            if (jsonObject.has("insertion"))
                message.setInsertion(jsonObject.get("insertion").getAsString());

            if (jsonObject.has("extra")) {
                JsonArray extraMessages = jsonObject.getAsJsonArray("extra");
                List<Message> extra = new ArrayList<>();
                for (int i = 0; i < extraMessages.size(); i++) {
                    JsonElement element = extraMessages.get(i);
                    if (element.isJsonPrimitive())
                        extra.add(new TextMessage(element.getAsString()));
                    else
                        extra.add(Message.fromJsonElement(element.getAsJsonObject()));
                }

                message.setExtraMessages(extra);
            }

            return message;
        } else {
            throw new IllegalArgumentException("Cannot convert \'" + jsonElement + "\' to a Message!");
        }
    }

    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("color", this.chatColor.toString());
        for (ChatFormat chatFormat : this.chatFormatList) {
            jsonObject.addProperty(chatFormat.toString(), true);
        }

        if (this.clickEvent != null) {
            JsonObject clickObject = new JsonObject();
            clickObject.addProperty("action", this.clickEvent.getActionType().toString());
            clickObject.addProperty("value", this.clickEvent.getValue());
            jsonObject.add("clickEvent", clickObject);
        }

        if (this.hoverEvent != null) {
            JsonObject hoverEvent = new JsonObject();
            hoverEvent.addProperty("action", this.hoverEvent.getActionType().toString());
            hoverEvent.add("value", this.hoverEvent.getValue().toJson());
            jsonObject.add("hoverEvent", hoverEvent);
        }

        if (this.insertion != null) {
            jsonObject.addProperty("insertion", this.insertion);
        }

        if (!this.extraMessages.isEmpty()) {
            JsonArray extra = new JsonArray();
            for (Message extraMessage : this.extraMessages) {
                extra.add(extraMessage.toJson());
            }

            jsonObject.add("extra", extra);
        }

        return jsonObject;
    }

    public String toJsonString() {
        return this.toJson().toString();
    }
}
