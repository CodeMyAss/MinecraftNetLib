package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketWorldBorder;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecWorldBorder implements Codec<PacketWorldBorder> {

    public ByteBuf encode(ByteBuf byteBuf, PacketWorldBorder packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getAction());

        switch (PacketWorldBorder.BorderAction.getById(packet.getAction())) {
            case SET_SIZE: {
                byteBuf.writeDouble(packet.getRadius());
                break;
            }
            case LERP_SIZE: {
                byteBuf.writeDouble(packet.getOldRadius());
                byteBuf.writeDouble(packet.getNewRadius());
                byteBuf.writeLong(packet.getSpeed());
                break;
            }
            case SET_CENTER: {
                byteBuf.writeDouble(packet.getX());
                byteBuf.writeDouble(packet.getZ());
                byteBuf.writeDouble(packet.getOldRadius());
                byteBuf.writeDouble(packet.getNewRadius());
                ByteBufUtils.writeVarLong(byteBuf, packet.getSpeed());
                ByteBufUtils.writeVarInt(byteBuf, packet.getPortalTeleportBoundary());
                ByteBufUtils.writeVarInt(byteBuf, packet.getWarningTime());
                ByteBufUtils.writeVarInt(byteBuf, packet.getWarningBlocks());
                break;
            }
            case SET_WARNING_TIME: {
                ByteBufUtils.writeVarInt(byteBuf, packet.getWarningTime());
                break;
            }
            case SET_WARNING_BLOCKS: {
                ByteBufUtils.writeVarInt(byteBuf, packet.getWarningBlocks());
                break;
            }
        }

        return byteBuf;
    }

    public PacketWorldBorder decode(ByteBuf byteBuf) {
        int actionId = ByteBufUtils.readVarInt(byteBuf);

        switch (PacketWorldBorder.BorderAction.getById(actionId)) {
            case SET_SIZE: {
                double radius = byteBuf.readDouble();
                return new PacketWorldBorder(actionId, radius);
            }
            case LERP_SIZE: {
                double oldRadius = byteBuf.readDouble();
                double newRadius = byteBuf.readDouble();
                long speed = byteBuf.readLong();
                return new PacketWorldBorder(actionId, oldRadius, newRadius, speed);
            }
            case SET_CENTER: {
                double x = byteBuf.readDouble();
                double z = byteBuf.readDouble();
                return new PacketWorldBorder(actionId, x, z);
            }
            case INITIALIZE: {
                double x = byteBuf.readDouble();
                double z = byteBuf.readDouble();
                double oldRadius = byteBuf.readDouble();
                double newRadius = byteBuf.readDouble();
                long speed = ByteBufUtils.readVarLong(byteBuf);
                int portalTeleportBoundary = ByteBufUtils.readVarInt(byteBuf);
                int warningTime = ByteBufUtils.readVarInt(byteBuf);
                int warningBlocks = ByteBufUtils.readVarInt(byteBuf);
                return new PacketWorldBorder(actionId, x, z, oldRadius, newRadius, speed, portalTeleportBoundary, warningTime, warningBlocks);
            }
            case SET_WARNING_TIME:
            case SET_WARNING_BLOCKS: {
                int warningBlocksOrTime = ByteBufUtils.readVarInt(byteBuf);
                return new PacketWorldBorder(actionId, warningBlocksOrTime);
            }
            default:
                throw new IllegalArgumentException("Illegal WorldBorder action-id: \'" + actionId + "\'!");
        }
    }
}
