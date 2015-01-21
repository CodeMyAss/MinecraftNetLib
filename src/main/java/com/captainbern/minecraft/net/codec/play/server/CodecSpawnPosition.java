package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketSpawnPosition;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecSpawnPosition implements Codec<PacketSpawnPosition> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnPosition packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());

        return byteBuf;
    }

    public PacketSpawnPosition decode(ByteBuf byteBuf) {
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);

        return new PacketSpawnPosition(blockVector.getX(), blockVector.getY(), blockVector.getZ());
    }
}
