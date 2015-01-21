package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.BlockVector;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketSpawnPainting;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecSpawnPainting implements Codec<PacketSpawnPainting> {

    public ByteBuf encode(ByteBuf byteBuf, PacketSpawnPainting packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        ByteBufUtils.writeUTF(byteBuf, packet.getTitle());
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        byteBuf.writeByte(packet.getDirection());
        
        return byteBuf;
    }

    public PacketSpawnPainting decode(ByteBuf byteBuf) {
        int entityId = ByteBufUtils.readVarInt(byteBuf);
        String title = ByteBufUtils.readUTF(byteBuf);
        BlockVector blockVector = ByteBufUtils.readBlockPosition(byteBuf);
        byte direction = byteBuf.readByte();
        
        return new PacketSpawnPainting(entityId, title, blockVector.getX(), blockVector.getY(), blockVector.getZ(), direction);
    }
}
