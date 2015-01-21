package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.inventory.ItemStack;
import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketCreativeInventoryAction;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecCreativeInventoryAction implements Codec<PacketCreativeInventoryAction> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketCreativeInventoryAction packet) {
        byteBuf.writeShort(packet.getSlot());
        ByteBufUtils.writeSlot(byteBuf, packet.getItem());

        return byteBuf;
    }

    @Override
    public PacketCreativeInventoryAction decode(ByteBuf byteBuf) {
        short slot = byteBuf.readShort();
        ItemStack itemStack = ByteBufUtils.readSlot(byteBuf);

        return new PacketCreativeInventoryAction(slot, itemStack);
    }
}
