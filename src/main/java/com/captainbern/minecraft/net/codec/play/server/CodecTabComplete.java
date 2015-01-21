package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketTabComplete;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecTabComplete implements Codec<PacketTabComplete> {

    public ByteBuf encode(ByteBuf byteBuf, PacketTabComplete packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getCount());
        for(String match : packet.getMatches()){
            ByteBufUtils.writeUTF(byteBuf, match);
        }
        
        return byteBuf;
    }

    public PacketTabComplete decode(ByteBuf byteBuf) {
        int count = ByteBufUtils.readVarInt(byteBuf);

        String matches[] = new String[count];
        for(int i = 0; i < count; i++){
            matches[i] = ByteBufUtils.readUTF(byteBuf);
        }
        
        return new PacketTabComplete(count, matches);
    }
}
