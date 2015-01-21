package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketChunkData;
import com.captainbern.litebot.net.packet.play.server.PacketMapChunkBulk;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class CodecMapChunkBulk implements Codec<PacketMapChunkBulk> {

    public ByteBuf encode(ByteBuf byteBuf, PacketMapChunkBulk packet) {
        byteBuf.writeBoolean(packet.hasSkylight());

        List<PacketChunkData> chunks = packet.getChunkData();
        ByteBufUtils.writeVarInt(byteBuf, chunks.size());

        // see: http://wiki.vg/Protocol#Map_Chunk_Bulk
        for (PacketChunkData chunkData : chunks) {
            byteBuf.writeInt(chunkData.getX());
            byteBuf.writeInt(chunkData.getZ());
            byteBuf.writeShort(chunkData.getBitmask());
        }

        for (PacketChunkData chunkData : chunks) {
            byteBuf.writeBytes(chunkData.getData());
        }

        return byteBuf;
    }

    public PacketMapChunkBulk decode(ByteBuf byteBuf) {
        boolean hasSkyLight = byteBuf.readBoolean();

        List<PacketChunkData> chunks = new ArrayList<>();

        int entries = ByteBufUtils.readVarInt(byteBuf);
        List<ChunkData> chunkDataEntries = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            int x = byteBuf.readInt();
            int z = byteBuf.readInt();
            int bitMask = byteBuf.readUnsignedShort();

            int chunkCount = Integer.bitCount(bitMask);
            int length = (chunkCount * ((4096 * 2) + 2048)) + (hasSkyLight ? chunkCount * 2048 : 0) + 256;

            chunkDataEntries.add(new ChunkData(x, z, bitMask, length));
        }

        for (ChunkData chunkData : chunkDataEntries) {
            byte[] data = new byte[chunkData.getDataLength()];
            byteBuf.readBytes(data);

            chunks.add(new PacketChunkData(chunkData.getX(), chunkData.getZ(), true, chunkData.getBitMask(), data));
        }

        return new PacketMapChunkBulk(hasSkyLight, chunks);
    }

    private class ChunkData {

        private int x;
        private int z;
        private int bitMask;
        private int dataLength;

        public ChunkData(int x, int z, int bitMask, int dataLength) {
            this.x = x;
            this.z = z;
            this.bitMask = bitMask;
            this.dataLength = dataLength;
        }

        public int getX() {
            return this.x;
        }

        public int getZ() {
            return this.z;
        }

        public int getBitMask() {
            return this.bitMask;
        }

        public int getDataLength() {
            return this.dataLength;
        }
    }
}
