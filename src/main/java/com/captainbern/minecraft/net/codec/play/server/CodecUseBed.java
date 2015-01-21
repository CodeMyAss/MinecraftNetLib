package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketUseBed;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecUseBed implements Codec<PacketUseBed> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUseBed packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        
        return byteBuf;
    }

    public PacketUseBed decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        
        return new PacketUseBed(entityId, blockVector.getX(), blockVector.getY(), blockVector.getZ());
    }
}
