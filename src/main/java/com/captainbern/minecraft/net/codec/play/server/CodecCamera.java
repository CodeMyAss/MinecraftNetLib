package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketCamera;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecCamera implements Codec<PacketCamera> {

    public ByteBuf encode(ByteBuf byteBuf, PacketCamera packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getCameraId());

        return byteBuf;
    }

    public PacketCamera decode(ByteBuf byteBuf) {
        int cameraId = ByteBufUtils.readVarInt(byteBuf);

        return new PacketCamera(cameraId);
    }
}
