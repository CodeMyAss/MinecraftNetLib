package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.entity.attribute.Attribute;
import com.captainbern.minecraft.game.entity.attribute.AttributeModifier;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEntityProperties;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CodecEntityProperties implements Codec<PacketEntityProperties> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityProperties packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());

        byteBuf.writeInt(packet.getAttributes().size());
        for (Attribute attribute : packet.getAttributes()) {
            ByteBufUtils.writeUTF(byteBuf, attribute.getType().getKey());
            byteBuf.writeDouble(attribute.getValue());

            ByteBufUtils.writeVarInt(byteBuf, attribute.getModifiers().size());
            for (AttributeModifier modifier : attribute.getModifiers()) {
                ByteBufUtils.writeUuid(byteBuf, modifier.getType());
                byteBuf.writeDouble(modifier.getAmount());
                byteBuf.writeByte(modifier.getOperation().getId());
            }
        }

        return byteBuf;
    }

    public PacketEntityProperties decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);

        int attributeLength = byteBuf.readInt();
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < attributeLength; i++) {
            String key = ByteBufUtils.readUTF(byteBuf);
            double value = byteBuf.readDouble();

            int modifierLength = ByteBufUtils.readVarInt(byteBuf);
            List<AttributeModifier> modifiers = new ArrayList<>();
            for (int j = 0; j < modifierLength; j++) {
                UUID type = ByteBufUtils.readUuid(byteBuf); // Some Bukkit plugins use a custom UUID to store persistent data on items
                double amount = byteBuf.readDouble();
                byte modifierOperation = byteBuf.readByte();

                modifiers.add(new AttributeModifier(type, amount, modifierOperation));
            }

            attributes.add(new Attribute(key, value, modifiers));
        }

        return new PacketEntityProperties(entityId, attributes);
    }
}
