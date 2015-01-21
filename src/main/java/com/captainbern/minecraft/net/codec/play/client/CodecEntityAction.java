package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketEntityAction;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEntityAction implements Codec<PacketEntityAction> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketEntityAction packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getTargetId());
        ByteBufUtils.writeVarInt(byteBuf, packet.getActionId());
        ByteBufUtils.writeVarInt(byteBuf, packet.getJumpBoost());

        return byteBuf;
    }

    @Override
    public PacketEntityAction decode(ByteBuf byteBuf) {
        int targetId = ByteBufUtils.readVarInt(byteBuf);
        int actionId = ByteBufUtils.readVarInt(byteBuf);
        int jumpBoost = ByteBufUtils.readVarInt(byteBuf);

        return new PacketEntityAction(targetId, actionId, jumpBoost);
    }
}
