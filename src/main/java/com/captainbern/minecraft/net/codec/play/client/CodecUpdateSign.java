package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.game.BlockVector;
import com.captainbern.minecraft.game.chat.TextMessage;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketUpdateSign;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecUpdateSign implements Codec<PacketUpdateSign> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketUpdateSign packet) {
        ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        for (TextMessage message : packet.getLines()) {
            ByteBufUtils.writeUTF(byteBuf, message.toJsonString());
        }

        return byteBuf;
    }

    @Override
    public PacketUpdateSign decode(ByteBuf byteBuf) {
        BlockVector position = ByteBufUtils.readBlockPosition(byteBuf);

        TextMessage[] lines = new TextMessage[4];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = (TextMessage) ByteBufUtils.readMessage(byteBuf);
        }

        return new PacketUpdateSign(position.getX(), position.getY(), position.getZ(), lines);
    }
}
