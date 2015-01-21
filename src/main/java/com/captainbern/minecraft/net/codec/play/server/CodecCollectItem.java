package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketCollectItem;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecCollectItem implements Codec<PacketCollectItem> {

    public ByteBuf encode(ByteBuf byteBuf, PacketCollectItem packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getItemEntityId());
        ByteBufUtils.writeVarInt(byteBuf, packet.getCollectorId());

        return byteBuf;
    }

    public PacketCollectItem decode(ByteBuf byteBuf) {
        int itemEntityId = ByteBufUtils.readVarInt(byteBuf);
        int collectorId = ByteBufUtils.readVarInt(byteBuf);

        return new PacketCollectItem(itemEntityId, collectorId);
    }
}
