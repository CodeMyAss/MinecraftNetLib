package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketTeams;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecTeams implements Codec<PacketTeams> {

    public ByteBuf encode(ByteBuf byteBuf, PacketTeams packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getTeamName());
        byteBuf.writeByte(packet.getMode());

        PacketTeams.TeamAction action = PacketTeams.TeamAction.getById(packet.getMode());
        if (action == PacketTeams.TeamAction.CREATE || action == PacketTeams.TeamAction.UPDATE_INFO) {
            ByteBufUtils.writeUTF(byteBuf, packet.getTeamName());
            byteBuf.writeByte(packet.getMode());
            ByteBufUtils.writeUTF(byteBuf, packet.getTeamDisplayName());
            ByteBufUtils.writeUTF(byteBuf, packet.getTeamPrefix());
            ByteBufUtils.writeUTF(byteBuf, packet.getTeamSuffix());
            byteBuf.writeByte(packet.getFriendlyFire());
            ByteBufUtils.writeUTF(byteBuf, packet.getNameTagVisibility());
            byteBuf.writeByte(packet.getColor());

            if (action == PacketTeams.TeamAction.CREATE)
                ByteBufUtils.writeStringArray(byteBuf, packet.getPlayers());

        } else if (action == PacketTeams.TeamAction.ADD_PLAYERS || action == PacketTeams.TeamAction.REMOVE_PLAYERS) {
            ByteBufUtils.writeStringArray(byteBuf, packet.getPlayers());
        }

        return byteBuf;
    }

    public PacketTeams decode(ByteBuf byteBuf) {
        String teamName = ByteBufUtils.readUTF(byteBuf);
        byte mode = byteBuf.readByte();

        PacketTeams.TeamAction action = PacketTeams.TeamAction.getById(mode);

        if (action == PacketTeams.TeamAction.CREATE || action == PacketTeams.TeamAction.UPDATE_INFO) {
            String teamDisplayName = ByteBufUtils.readUTF(byteBuf);
            String teamPrefix = ByteBufUtils.readUTF(byteBuf);
            String teamSuffix = ByteBufUtils.readUTF(byteBuf);
            byte friendlyFire = byteBuf.readByte();
            String nameTagVisibility = ByteBufUtils.readUTF(byteBuf);
            byte color = byteBuf.readByte();

            if (action == PacketTeams.TeamAction.CREATE) {
                String[] players = ByteBufUtils.readStringArray(byteBuf);
                return new PacketTeams(teamName, mode, teamDisplayName, teamPrefix, teamSuffix, friendlyFire, nameTagVisibility, color, players);
            }

            return new PacketTeams(teamName, mode, teamDisplayName, teamPrefix, teamSuffix, friendlyFire, nameTagVisibility, color);
        } else if (action == PacketTeams.TeamAction.ADD_PLAYERS || action == PacketTeams.TeamAction.REMOVE_PLAYERS) {
            String[] players = ByteBufUtils.readStringArray(byteBuf);
            return new PacketTeams(teamName, mode, players);
        }

        return new PacketTeams(teamName, mode);
    }
}
