package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.BlockVector;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketEffect;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecEffect implements Codec<PacketEffect> {

    public ByteBuf encode(ByteBuf byteBuf, PacketEffect packet) {
        byteBuf.writeInt(packet.getEffectId());
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeInt(packet.getData());
        byteBuf.writeBoolean(packet.isIgnoreDistance());

        return byteBuf;
    }

    public PacketEffect decode(ByteBuf byteBuf) {
        int effectId = byteBuf.readInt();
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        int data = byteBuf.readInt();
        boolean ignoreDistance = byteBuf.readBoolean();

        return new PacketEffect(effectId, blockVector.getX(), blockVector.getY(), blockVector.getZ(), data, ignoreDistance);
    }
}
