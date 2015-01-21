package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketStatistics;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CodecStatistics implements Codec<PacketStatistics> {

    public ByteBuf encode(ByteBuf byteBuf, PacketStatistics packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getEntries().size());

        for(Entry<String,Integer> entry:packet.getEntries().entrySet()){
            ByteBufUtils.writeUTF(byteBuf, entry.getKey());
            ByteBufUtils.writeVarInt(byteBuf, entry.getValue());
        }
        
        return byteBuf;
    }

    public PacketStatistics decode(ByteBuf byteBuf) {
        int count = ByteBufUtils.readVarInt(byteBuf);

        Map<String, Integer> contents = new HashMap<>();
        for(int i = 0; i < count; i++){
            contents.put(ByteBufUtils.readUTF(byteBuf), ByteBufUtils.readVarInt(byteBuf));
        }
        
        return new PacketStatistics(contents);
    }
}
