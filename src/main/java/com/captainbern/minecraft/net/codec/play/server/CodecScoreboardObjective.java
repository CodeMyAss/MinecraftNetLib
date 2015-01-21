package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.server.PacketScoreboardObjective;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecScoreboardObjective implements Codec<PacketScoreboardObjective> {

    public ByteBuf encode(ByteBuf byteBuf, PacketScoreboardObjective packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getObjectiveName());
        byteBuf.writeByte(packet.getMode());

        if (packet.getMode() == 0 || packet.getMode() == 2) {
            ByteBufUtils.writeUTF(byteBuf, packet.getValue());
            ByteBufUtils.writeUTF(byteBuf, packet.getType());
        }

        return byteBuf;
    }

    public PacketScoreboardObjective decode(ByteBuf byteBuf) {
        String objectiveMode = ByteBufUtils.readUTF(byteBuf);
        byte mode = byteBuf.readByte();

        if (mode == 0 || mode == 2) {
            String value = ByteBufUtils.readUTF(byteBuf);
            String type = ByteBufUtils.readUTF(byteBuf);

            return new PacketScoreboardObjective(objectiveMode, mode, value, type);
        }

        return new PacketScoreboardObjective(objectiveMode, mode);
    }
}
