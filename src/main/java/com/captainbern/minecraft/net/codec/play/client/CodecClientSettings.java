package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.client.PacketClientSettings;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecClientSettings implements Codec<PacketClientSettings> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketClientSettings packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getLocale());
        byteBuf.writeByte(packet.getViewDistance());
        byteBuf.writeByte(packet.getChatFlags());
        byteBuf.writeBoolean(packet.isChatColoursEnabled());
        byteBuf.writeByte(packet.getSkinSettings());

        return byteBuf;
    }

    @Override
    public PacketClientSettings decode(ByteBuf byteBuf) {
        String locale = ByteBufUtils.readUTF(byteBuf);
        byte viewDistance = byteBuf.readByte();
        byte chatFlags = byteBuf.readByte();
        boolean chatColoursEnabled = byteBuf.readBoolean();
        int skinSettings = byteBuf.readUnsignedByte();

        return new PacketClientSettings(locale, viewDistance, chatFlags, chatColoursEnabled, skinSettings);
    }
}
