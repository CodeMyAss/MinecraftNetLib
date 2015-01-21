package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketEntityEquipment;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityEquipment implements Codec<PacketEntityEquipment> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEntityEquipment packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        byteBuf.writeShort(packet.getSlot());
        ByteBufUtils.writeSlot(byteBuf, packet.getItemStack());

        return byteBuf;
    }

    public PacketEntityEquipment decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        int slot = byteBuf.readShort();
        ItemStack itemStack = ByteBufUtils.readSlot(byteBuf);

        return new PacketEntityEquipment(entityId, slot, itemStack);
    }
}
