package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketAttachEntity;
import io.netty.buffer.ByteBuf;

public class CodecAttachEntity implements Codec<PacketAttachEntity> {

    public ByteBuf encode(ByteBuf byteBuf, PacketAttachEntity packet) {
        byteBuf.writeInt(packet.getEntityId());
        byteBuf.writeInt(packet.getVehicleId());
        byteBuf.writeBoolean(packet.isLeash());

        return byteBuf;
    }

    public PacketAttachEntity decode(ByteBuf byteBuf) {
        int entityId = byteBuf.readInt();
        int vehicelId = byteBuf.readInt();
        boolean leash = byteBuf.readBoolean();

        return new PacketAttachEntity(entityId, vehicelId, leash);
    }
}
