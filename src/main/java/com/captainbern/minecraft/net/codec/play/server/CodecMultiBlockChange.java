package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketBlockChange;
import com.captainbern.minecraft.net.packet.play.server.PacketMultiBlockChange;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class CodecMultiBlockChange implements Codec<PacketMultiBlockChange> {

    public ByteBuf encode(ByteBuf byteBuf, PacketMultiBlockChange packet) {
        byteBuf.writeInt(packet.getX());
        byteBuf.writeInt(packet.getZ());

        // See: http://wiki.vg/Protocol#Multi_Block_Change
        ByteBufUtils.writeVarInt(byteBuf, packet.getRecords().size());
        for (PacketBlockChange blockChange : packet.getRecords()) {
            int position = (((blockChange.getX() & 0x0f) << 12) | ((blockChange.getZ() & 0x0f) << 8) | (blockChange.getY()));
            byteBuf.writeShort(position); // 16-bit int
            ByteBufUtils.writeVarInt(byteBuf, blockChange.getType());
        }

        return byteBuf;
    }

    public PacketMultiBlockChange decode(ByteBuf byteBuf) {
        int x = byteBuf.readInt();
        int z = byteBuf.readInt();

        int records = ByteBufUtils.readVarInt(byteBuf);
        List<PacketBlockChange> blockCanges = new ArrayList<>();
        for (int i = 0; i < records; i++) {
            int position = byteBuf.readShort();

            int posX = (position >> 12) & 0xf;
            int posZ = (position >> 8) & 0xf;
            int posY = (position & 0xff);

            int type = ByteBufUtils.readVarInt(byteBuf);

            blockCanges.add(new PacketBlockChange(posX, posY, posZ, type));
        }

        return new PacketMultiBlockChange(x, z, blockCanges);
    }
}
