package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketExplosion;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class CodecExplosion implements Codec<PacketExplosion> {

    public ByteBuf encode(ByteBuf byteBuf, PacketExplosion packet) {
        byteBuf.writeFloat(packet.getX());
        byteBuf.writeFloat(packet.getY());
        byteBuf.writeFloat(packet.getZ());
        byteBuf.writeFloat(packet.getRadius());

        byteBuf.writeInt(packet.getBlockRecordList().size());
        for (PacketExplosion.BlockRecord record : packet.getBlockRecordList()) {
            byteBuf.writeByte(record.getX());
            byteBuf.writeByte(record.getY());
            byteBuf.writeByte(record.getZ());
        }

        byteBuf.writeFloat(packet.getPlayerMotionX());
        byteBuf.writeFloat(packet.getPlayerMotionY());
        byteBuf.writeFloat(packet.getPlayerMotionY());

        return byteBuf;
    }

    public PacketExplosion decode(ByteBuf byteBuf) {
        float x = byteBuf.readFloat();
        float y = byteBuf.readFloat();
        float z = byteBuf.readFloat();
        float radius = byteBuf.readFloat();

        int recordCount = byteBuf.readInt();
        List<PacketExplosion.BlockRecord> recordList = new ArrayList<>();
        for (int i = 0; i < recordCount; i++) {
            byte recordX = byteBuf.readByte();
            byte recordY = byteBuf.readByte();
            byte recordZ = byteBuf.readByte();

            recordList.add(new PacketExplosion.BlockRecord(recordX, recordY, recordZ));
        }

        float playerMotionX = byteBuf.readFloat();
        float playerMotionY = byteBuf.readFloat();
        float playerMotionZ = byteBuf.readFloat();

        return new PacketExplosion(x, y, z, radius, recordList, playerMotionX, playerMotionY, playerMotionZ);
    }
}
