package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketUseEntity;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecUseEntity implements Codec<PacketUseEntity> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketUseEntity packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getTargetId());
        ByteBufUtils.writeVarInt(byteBuf, packet.getUseAction());

        if (packet.getUseAction() == PacketUseEntity.UseAction.INTERACT_AT.getId()) {
            byteBuf.writeFloat(packet.getTargetX());
            byteBuf.writeFloat(packet.getTargetY());
            byteBuf.writeFloat(packet.getTargetZ());
        }

        return byteBuf;
    }

    @Override
    public PacketUseEntity decode(ByteBuf byteBuf) {
        int targetId = ByteBufUtils.readVarInt(byteBuf);
        int action = ByteBufUtils.readVarInt(byteBuf);

        if (action == PacketUseEntity.UseAction.INTERACT_AT.getId()) {
            float x = byteBuf.readFloat();
            float y = byteBuf.readFloat();
            float z = byteBuf.readFloat();

            return new PacketUseEntity(targetId, action, x, y, z);
        }

        return new PacketUseEntity(targetId, action);
    }
}
