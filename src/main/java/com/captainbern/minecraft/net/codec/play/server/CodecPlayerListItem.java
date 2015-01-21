package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListItem;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListItem.PlayerListEntry;
import com.captainbern.minecraft.net.packet.play.server.PacketPlayerListItem.Property;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.UUID;

public class CodecPlayerListItem implements Codec<PacketPlayerListItem> {

    public ByteBuf encode(ByteBuf byteBuf, PacketPlayerListItem packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getAction());
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntries().length);

        PacketPlayerListItem.ListAction action = PacketPlayerListItem.ListAction.getById(packet.getAction());

        for (PacketPlayerListItem.PlayerListEntry entry : packet.getEntries()) {
            ByteBufUtils.writeUuid(byteBuf, entry.getUuid());

            switch (action) {
                case ADD_PLAYER: {
                    ByteBufUtils.writeUTF(byteBuf, entry.getName());

                    ByteBufUtils.writeVarInt(byteBuf, entry.getProperties().length);
                    for (Property property : entry.getProperties()) {
                        ByteBufUtils.writeUTF(byteBuf, property.getName());
                        ByteBufUtils.writeUTF(byteBuf, property.getValue());

                        byteBuf.writeBoolean(property.isSigned());
                        if (property.isSigned())
                            ByteBufUtils.writeUTF(byteBuf, property.getSignature());
                    }

                    ByteBufUtils.writeVarInt(byteBuf, entry.getGameMode());
                    ByteBufUtils.writeVarInt(byteBuf, entry.getPing());

                    byteBuf.writeBoolean(entry.hasDisplayName());
                    if (entry.hasDisplayName())
                        ByteBufUtils.writeMessage(byteBuf, entry.getDisplayName());

                    break;
                }
                case UPDATE_GAMEMODE: {
                    ByteBufUtils.writeVarInt(byteBuf, entry.getGameMode());
                    break;
                }
                case UPDATE_LATENCY: {
                    ByteBufUtils.writeVarInt(byteBuf, entry.getPing());
                    break;
                }
                case UPDATE_DISLAY_NAME: {
                    byteBuf.writeBoolean(entry.hasDisplayName());
                    if(entry.hasDisplayName())
                        ByteBufUtils.writeMessage(byteBuf, entry.getDisplayName());

                    break;
                }
                case REMOVE_PLAYER: {
                    // nope
                    break;
                }
                default:
                    throw new IllegalStateException("Illegal action: \'" + packet.getAction() + "\'!");
            }
        }

        return byteBuf;
    }

    public PacketPlayerListItem decode(ByteBuf byteBuf) {
        int action = ByteBufUtils.readVarInt(byteBuf);

        int entryCount = ByteBufUtils.readVarInt(byteBuf);
        PlayerListEntry[] entries = new PlayerListEntry[entryCount];

        PacketPlayerListItem.ListAction listAction = PacketPlayerListItem.ListAction.getById(action);

        for (int i = 0; i < entries.length; i++) {
            UUID uuid = ByteBufUtils.readUuid(byteBuf);

            switch (listAction) {
                case ADD_PLAYER: {
                    String name = ByteBufUtils.readUTF(byteBuf);

                    int propertyCount = ByteBufUtils.readVarInt(byteBuf);
                    Property[] properties = new Property[propertyCount];

                    for (int j = 0; j < propertyCount; j++){
                        String pName = ByteBufUtils.readUTF(byteBuf);
                        String pValue = ByteBufUtils.readUTF(byteBuf);
                        boolean pSigned = byteBuf.readBoolean();
                        String pSig = null;
                        if (pSigned)
                            pSig = ByteBufUtils.readUTF(byteBuf);

                        properties[j] = new Property(pName, pValue, pSigned, pSig);
                    }

                    int gameMode = ByteBufUtils.readVarInt(byteBuf);
                    int ping = ByteBufUtils.readVarInt(byteBuf);

                    Message displayName = null;
                    boolean hasDisplayName = byteBuf.readBoolean();
                    if (hasDisplayName)
                        displayName = ByteBufUtils.readMessage(byteBuf);

                    entries[i] = new PlayerListEntry(uuid, name, properties, gameMode, ping, hasDisplayName, displayName);
                    break;
                }
                case UPDATE_GAMEMODE: {
                    int gameMode = ByteBufUtils.readVarInt(byteBuf);
                    entries[i] = new PlayerListEntry(uuid, gameMode);
                    break;
                }
                case UPDATE_LATENCY: {
                    int latency = ByteBufUtils.readVarInt(byteBuf);
                    entries[i] = new PlayerListEntry(uuid, latency);
                    break;
                }
                case UPDATE_DISLAY_NAME: {
                    boolean hasDisplayName = byteBuf.readBoolean();
                    if (hasDisplayName) {
                        Message displayName = ByteBufUtils.readMessage(byteBuf);
                        entries[i] = new PlayerListEntry(uuid, hasDisplayName, displayName);
                    } else {
                        entries[i] = new PlayerListEntry(uuid);
                    }
                    break;
                }
                case REMOVE_PLAYER: {
                    entries[i] = new PlayerListEntry(uuid);
                    break;
                }
                default:
                    throw new IllegalStateException("Illegal action: \'" + action + "\'!");
            }
        }

        return new PacketPlayerListItem(action,entries);
    }
}
