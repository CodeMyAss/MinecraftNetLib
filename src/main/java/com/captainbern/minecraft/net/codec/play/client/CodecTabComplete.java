package com.captainbern.minecraft.net.codec.play.client;

import com.captainbern.litebot.net.codec.Codec;
import com.captainbern.litebot.net.packet.play.client.PacketTabComplete;
import com.captainbern.litebot.net.utils.ByteBufUtils;
import com.captainbern.litebot.world.block.BlockVector;
import io.netty.buffer.ByteBuf;

public class CodecTabComplete implements Codec<PacketTabComplete> {

    @Override
    public ByteBuf encode(ByteBuf byteBuf, PacketTabComplete packet) {
        ByteBufUtils.writeUTF(byteBuf, packet.getText());
        byteBuf.writeBoolean(packet.hasPosition());

        if (packet.hasPosition()) {
            ByteBufUtils.writeBlockPosition(byteBuf, packet.getX(), packet.getY(), packet.getZ());
        }

        return byteBuf;
    }

    @Override
    public PacketTabComplete decode(ByteBuf byteBuf) {
        String text = ByteBufUtils.readUTF(byteBuf);

        boolean hasPosition = byteBuf.readBoolean();
        if (hasPosition) {
            BlockVector position = ByteBufUtils.readBlockPosition(byteBuf);
            return new PacketTabComplete(text, position.getX(), position.getY(), position.getZ());
        }

        return new PacketTabComplete(text);
    }
}
