package com.captainbern.minecraft.net.codec.play.server;

import com.captainbern.minecraft.net.codec.Codec;
import com.captainbern.minecraft.net.packet.play.server.PacketOpenWindow;
import com.captainbern.minecraft.net.util.ByteBufUtils;
import com.captainbern.minecraft.game.chat.Message;
import io.netty.buffer.ByteBuf;

public class CodecOpenWindow implements Codec<PacketOpenWindow> {

    public ByteBuf encode(ByteBuf byteBuf, PacketOpenWindow packet) {
        byteBuf.writeByte(packet.getWindowId());
        ByteBufUtils.writeUTF(byteBuf, packet.getInventoryType());
        ByteBufUtils.writeMessage(byteBuf, packet.getWindowTitle());
        byteBuf.writeByte(packet.getNumberOfSlots());

        if (packet.getInventoryType().equals("EntityHorse")){
            ByteBufUtils.writeVarInt(byteBuf, packet.getEntityId());
        }
        
        return byteBuf;
    }

    public PacketOpenWindow decode(ByteBuf byteBuf) {
        byte windowId = byteBuf.readByte();
        String inventoryType = ByteBufUtils.readUTF(byteBuf);
        Message windowTitle = ByteBufUtils.readMessage(byteBuf);
        byte slotCount = byteBuf.readByte();

        int entityId = 0;
        if(inventoryType.equals("EntityHorse")){
            entityId = ByteBufUtils.readVarInt(byteBuf);
        }
        
        return new PacketOpenWindow(windowId, inventoryType, windowTitle, slotCount, entityId);
    }
}
