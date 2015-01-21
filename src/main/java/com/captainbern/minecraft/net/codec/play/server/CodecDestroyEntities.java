package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketDestroyEntities;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecDestroyEntities implements Codec<PacketDestroyEntities> {

    public ByteBuf encode(ByteBuf byteBuf, PacketDestroyEntities packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getIds().length);
        for (int i : packet.getIds()) {
            ByteBufUtils.writeVarInt(byteBuf, i);
        }

        return byteBuf;
    }

    public PacketDestroyEntities decode(ByteBuf byteBuf) {
        int[] ids = new int[ByteBufUtils.readVarInt(byteBuf)];
        for (int i = 0; i < ids.length; i++) {
            ids[0] = ByteBufUtils.readVarInt(byteBuf);
        }

        return new PacketDestroyEntities(ids);
    }
}
