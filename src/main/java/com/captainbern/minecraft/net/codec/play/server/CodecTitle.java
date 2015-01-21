package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketTitle;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class CodecTitle implements Codec<PacketTitle> {

    public ByteBuf encode(ByteBuf byteBuf, PacketTitle packet) {
        ByteBufUtils.writeVarInt(byteBuf, packet.getAction());

        switch (PacketTitle.TitleAction.getById(packet.getAction())) {
            case TITLE:
            case SUBTITLE: {
                ByteBufUtils.writeMessage(byteBuf, packet.getMessage());
                break;
            }
            case TIMES: {
                byteBuf.writeInt(packet.getFadeIn());
                byteBuf.writeInt(packet.getStay());
                byteBuf.writeInt(packet.getFadeOut());
                break;
            }
        }

        return byteBuf;
    }

    public PacketTitle decode(ByteBuf byteBuf) {
        int actionId = ByteBufUtils.readVarInt(byteBuf);

        switch (PacketTitle.TitleAction.getById(actionId)) {
            case TITLE:
            case SUBTITLE: {
                Message message = ByteBufUtils.readMessage(byteBuf);
                return new PacketTitle(actionId, message);
            }
            case TIMES: {
                int fadeIn = byteBuf.readInt();
                int stay = byteBuf.readInt();
                int fadeOut = byteBuf.readInt();
                return new PacketTitle(actionId, fadeIn, stay, fadeOut);
            }
            default:
                return new PacketTitle(actionId);
        }
    }
}
