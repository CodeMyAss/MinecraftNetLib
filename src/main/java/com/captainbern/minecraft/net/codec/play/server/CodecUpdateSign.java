package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketUpdateSign;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.litebot.util.chat.Message;
import com.captainbern.minecraft.game.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecUpdateSign implements Codec<PacketUpdateSign> {

    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateSign packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        ByteBufUtils.writeMessage(byteBuf,packet.getLine1());
        ByteBufUtils.writeMessage(byteBuf,packet.getLine2());
        ByteBufUtils.writeMessage(byteBuf,packet.getLine3());
        ByteBufUtils.writeMessage(byteBuf,packet.getLine4());
        
        return byteBuf;
    }

    public PacketUpdateSign decode(ByteBuf byteBuf) {
        BlockVector location = ByteBufUtils.readBlockPosition(byteBuf);
        Message line1 = ByteBufUtils.readMessage(byteBuf);
        Message line2 = ByteBufUtils.readMessage(byteBuf);
        Message line3 = ByteBufUtils.readMessage(byteBuf);
        Message line4 = ByteBufUtils.readMessage(byteBuf);
        
        return new PacketUpdateSign(location.getX(), location.getY(), location.getZ(), line1, line2, line3, line4);
    }
}
