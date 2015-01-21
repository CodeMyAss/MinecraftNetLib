package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketClientStatus;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecClientStatus implements Codec<PacketClientStatus> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketClientStatus packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getActionId());

        return byteBuf;
    }

    @Override
    public PacketClientStatus decode(ByteBuf byteBuf) {
        int actionId = ByteBufUtils.readVarInt(byteBuf);

        return new PacketClientStatus(actionId);
    }
}
