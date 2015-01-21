package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketCombatEvent;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecCombatEvent implements Codec<PacketCombatEvent> {

    public ByteBuf encode(ByteBuf byteBuf, PacketCombatEvent packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getCombatEvent().getId());

        switch (packet.getCombatEvent()) {
            case END_COMBAT: {
                ByteBufUtils.writeVarInt(byteBuf, packet.getDuration());
                byteBuf.writeInt(packet.getEntityId());
            }
            case ENTITY_DEAD: {
                ByteBufUtils.writeVarInt(byteBuf, packet.getPlayerId());
                byteBuf.writeInt(packet.getEntityId());
                ByteBufUtils.writeUTF(byteBuf, packet.getMessage());
            }
        }

        return byteBuf;
    }

    public PacketCombatEvent decode(ByteBuf byteBuf) {
        int id = ByteBufUtils.readVarInt(byteBuf);
        PacketCombatEvent.CombatEvent event = PacketCombatEvent.CombatEvent.getById(id);

        switch (event) {
            case END_COMBAT: {
                int duration = ByteBufUtils.readVarInt(byteBuf);
                int entityId = byteBuf.readInt();
                return new PacketCombatEvent(event, duration, entityId);
            }
            case ENTITY_DEAD: {
                int playerId = ByteBufUtils.readVarInt(byteBuf);
                int entityId = byteBuf.readInt();
                String message = ByteBufUtils.readUTF(byteBuf);
                return new PacketCombatEvent(event, playerId, entityId, message);
            }
            default:
                return new PacketCombatEvent(event);
        }
    }
}
