package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.nbt.NbtTagCompound;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateEntityNBT;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecUpdateEntityNBT implements Codec<PacketUpdateEntityNBT> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateEntityNBT packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeNbt(byteBuf, packet.getNbtTagCompound());

        return byteBuf;
    }

    public PacketUpdateEntityNBT decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        NbtTagCompound tagCompound = ByteBufUtils.readNbt(byteBuf);

        return new PacketUpdateEntityNBT(entityId, tagCompound);
    }
}
