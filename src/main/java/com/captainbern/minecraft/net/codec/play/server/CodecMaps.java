package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketMaps;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class CodecMaps implements Codec<PacketMaps> {

    public ByteBuf encode(ByteBuf byteBuf, PacketMaps packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getMapId());
        byteBuf.writeByte(packet.getScale());

        ByteBufUtils.writeVarInt(byteBuf, packet.getIcons().size());
        for (PacketMaps.Icon icon : packet.getIcons()) {
            byteBuf.writeByte((icon.getRotation() << 4) | icon.getType());
            byteBuf.writeByte(icon.getX());
            byteBuf.writeByte(icon.getY());
        }

        if (packet.getSection() == null) {
            byteBuf.writeByte(0);
        } else {
            byteBuf.writeByte(packet.getSection().getWidth());
            byteBuf.writeByte(packet.getSection().getHeight());
            byteBuf.writeByte(packet.getSection().getX());
            byteBuf.writeByte(packet.getSection().getY());
            ByteBufUtils.writeVarInt(byteBuf, packet.getSection().getData().length);
            byteBuf.writeBytes(packet.getSection().getData());
        }

        return byteBuf;
    }

    public PacketMaps decode(ByteBuf byteBuf) {
        int mapId = ByteBufUtils.readVarInt(byteBuf);
        byte scale = byteBuf.readByte();

        int iconAmount = ByteBufUtils.readVarInt(byteBuf);
        List<PacketMaps.Icon> icons = new ArrayList<>();
        for (int i = 0; i < iconAmount; i++) {
            byte rotationAndType = byteBuf.readByte();
            byte rotation = (byte) ((rotationAndType >> 4) & 0xf);
            byte type = (byte) (rotationAndType & 0xf);

            byte x = byteBuf.readByte();
            byte y = byteBuf.readByte();

            icons.add(new PacketMaps.Icon(rotation, type, x, y));
        }

        PacketMaps.MapSection section = null;
        byte width = byteBuf.readByte();
        if (width != 0) {
            byte height = byteBuf.readByte();
            byte x = byteBuf.readByte();
            byte y = byteBuf.readByte();

            byte[] data = new byte[ByteBufUtils.readVarInt(byteBuf)];
            byteBuf.readBytes(data);

            section = new PacketMaps.MapSection(width, height, x, y, data);
        }

        return new PacketMaps(mapId, scale, icons, section);
    }
}
