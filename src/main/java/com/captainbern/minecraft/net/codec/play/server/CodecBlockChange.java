package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketBlockChange;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecBlockChange implements Codec<PacketBlockChange> {

    public ByteBuf encode(ByteBuf byteBuf, PacketBlockChange packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        ByteBufUtils.writeVarInt(byteBuf, packet.getType());

        return byteBuf;
    }

    public PacketBlockChange decode(ByteBuf byteBuf) {
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        int type = ByteBufUtils.readVarInt(byteBuf);

        return new PacketBlockChange(blockVector.getX(), blockVector.getY(), blockVector.getZ(), type);
    }
}
