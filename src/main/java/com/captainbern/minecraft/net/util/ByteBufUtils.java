package com.captainbern.minecraft.net.util;

import com.captainbern.minecraft.game.BlockVector;
import com.captainbern.minecraft.game.ItemStack;
import com.captainbern.minecraft.game.Position;
import com.captainbern.minecraft.game.Rotation;
import com.captainbern.minecraft.game.chat.Message;
import com.captainbern.minecraft.game.entity.metadata.Metadata;
import com.captainbern.minecraft.game.entity.metadata.MetadataType;
import com.captainbern.minecraft.game.nbt.NbtCompressedStreamTools;
import com.captainbern.minecraft.game.nbt.NbtReadLimiter;
import com.captainbern.minecraft.game.nbt.NbtTagCompound;
import com.captainbern.minecraft.game.nbt.NbtTagType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ByteBufUtils {

    private ByteBufUtils() {
        super();
    }

    public static UUID readUuid(ByteBuf buf) {
        return new UUID(buf.readLong(), buf.readLong());
    }

    public static void writeUuid(ByteBuf buf, UUID uuid) {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
    }

    public static BlockVector readBlockPosition(ByteBuf byteBuf) {
        long pos = byteBuf.readLong(); // 64bit long
        int x = (int) (pos >> 38);
        int y = (int) ((pos >> 26) & 0xFFF);
        int z = (int) (pos << 38 >> 38);

        return new BlockVector(x, y, z);
    }

    public static void writeBlockPosition(ByteBuf byteBuf, BlockVector vector) {
        writeBlockPosition(byteBuf, vector.getX(), vector.getY(), vector.getZ());
    }

    public static void writeBlockPosition(ByteBuf buf, long x, long y, long z) {
        buf.writeLong(((x & 0x3ffffff) << 38) | ((y & 0xfff) << 26) | (z & 0x3ffffff));
    }

    public static Message readMessage(ByteBuf byteBuf) {
        return Message.fromJsonString(readUTF(byteBuf));
    }

    public static void writeMessage(ByteBuf byteBuf, Message message) {
        writeUTF(byteBuf, message.toJsonString());
    }

    public static ItemStack readSlot(ByteBuf byteBuf) {
        short item = byteBuf.readShort();
        if (item == -1)
            return null;

        int amount = byteBuf.readUnsignedByte();
        short durability = byteBuf.readShort();

        NbtTagCompound tagCompound = readNbt(byteBuf);

        return new ItemStack(item, amount, durability, tagCompound);
    }

    public static void writeSlot(ByteBuf byteBuf, ItemStack itemStack) {
        if (itemStack == null || itemStack.getId() == 0)
            byteBuf.writeShort(-1);

        byteBuf.writeShort(itemStack.getId());
        byteBuf.writeByte(itemStack.getAmount());
        byteBuf.writeShort(itemStack.getData());
        writeNbt(byteBuf, itemStack.getTagCompound());
    }

    public static NbtTagCompound readNbt(ByteBuf byteBuf) {
        int readerIndex = byteBuf.readerIndex();

        byte type = byteBuf.readByte();

        if (type == 0)
            return null;

        byteBuf.readerIndex(readerIndex);

        return NbtCompressedStreamTools.read(new ByteBufInputStream(byteBuf), new NbtReadLimiter(0x20000));
    }

    public static void writeNbt(ByteBuf byteBuf, NbtTagCompound tagCompound) {
        if (tagCompound == null || tagCompound.getType() == NbtTagType.TAG_END) {
            byteBuf.writeByte(0);
            return;
        }

        try {
            NbtCompressedStreamTools.write(tagCompound, new ByteBufOutputStream(byteBuf));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while writing an NbtTagCompound!", e);
        }
    }

    public static List<Metadata> readMetadata(ByteBuf byteBuf) {
        List<Metadata> metadataList = new ArrayList<>();

        byte item;
        while ((item = byteBuf.readByte()) != 0x7f) {
            MetadataType type = MetadataType.getById((item & 0xe0) >> 5);
            int index = item & 0x1f;

            switch (type) {
                case BYTE: {
                    metadataList.add(new Metadata<>(index, byteBuf.readByte()));
                    break;
                }
                case SHORT: {
                    metadataList.add(new Metadata<>(index, byteBuf.readShort()));
                    break;
                }
                case INT: {
                    metadataList.add(new Metadata<>(index, byteBuf.readInt()));
                    break;
                }
                case FLOAT: {
                    metadataList.add(new Metadata<>(index, byteBuf.readFloat()));
                    break;
                }
                case STRING: {
                    metadataList.add(new Metadata<>(index, readUTF(byteBuf)));
                    break;
                }
                case ITEM: {
                    metadataList.add(new Metadata<>(index, readSlot(byteBuf)));
                    break;
                }
                case POSITION: {
                    int x = byteBuf.readInt();
                    int y = byteBuf.readInt();
                    int z = byteBuf.readInt();
                    metadataList.add(new Metadata<>(index, new Position(x, y, z)));
                    break;
                }
                case ROTATION: {
                    float pitch = byteBuf.readFloat();
                    float yaw = byteBuf.readFloat();
                    float roll = byteBuf.readFloat();
                    metadataList.add(new Metadata<>(index, new Rotation(pitch, yaw, roll)));
                    break;
                }
            }
        }

        return metadataList;
    }

    public static void writeMetadata(ByteBuf byteBuf, List<Metadata> metadata) {
        for (Metadata entry : metadata) {
            int index = entry.getIndex();
            Object value = entry.getValue();

            if (value == null)
                continue;

            int type = entry.getType().getId();
            byteBuf.writeByte((type << 5) | index);

            switch (entry.getType()) {
                case BYTE: {
                    byteBuf.writeByte((byte) entry.getValue());
                    break;
                }
                case SHORT: {
                    byteBuf.writeShort((short) entry.getValue());
                    break;
                }
                case INT: {
                    byteBuf.writeInt((int) entry.getValue());
                    break;
                }
                case FLOAT: {
                    byteBuf.writeFloat((float) entry.getValue());
                    break;
                }
                case STRING: {
                    writeUTF(byteBuf, (String) entry.getValue());
                    break;
                }
                case ITEM: {
                    writeSlot(byteBuf, (ItemStack) entry.getValue());
                    break;
                }
                case POSITION: {
                    Position position = (Position) entry.getValue();
                    byteBuf.writeInt(position.getX());
                    byteBuf.writeInt(position.getY());
                    byteBuf.writeInt(position.getZ());
                    break;
                }
                case ROTATION: {
                    Rotation rotation = (Rotation) entry.getValue();
                    byteBuf.writeFloat(rotation.getPitch());
                    byteBuf.writeFloat(rotation.getYaw());
                    byteBuf.writeFloat(rotation.getRoll());
                    break;
                }
            }
        }

        byteBuf.writeByte(0x7f);
    }

    public static int readVarInt(ByteBuf byteBuf) {
        int out = 0;
        int bytes = 0;
        byte in;
        while (true) {
            in = byteBuf.readByte();
            out |= (in & 0x7F) << (bytes++ * 7);
            if (bytes > 5) {
                throw new IllegalStateException("Integer is bigger than maximum allowed!");
            }
            if ((in & 0x80) != 0x80) {
                break;
            }
        }
        return out;
    }

    public static void writeVarInt(ByteBuf byteBuf, int varInt) {
        int part;
        while (true) {
            part = varInt & 0x7F;
            varInt >>>= 7;
            if (varInt != 0) {
                part |= 0x80;
            }
            byteBuf.writeByte(part);
            if (varInt == 0) {
                break;
            }
        }
    }

    public static long readVarLong(ByteBuf buf) {
        long out = 0;
        int bytes = 0;
        byte in;
        while (true) {
            in = buf.readByte();
            out |= (in & 0x7F) << (bytes++ * 7);
            if (bytes > 10) {
                throw new IllegalStateException("Attempt to read long bigger than allowed for a varlong!");
            }
            if ((in & 0x80) != 0x80) {
                break;
            }
        }
        return out;
    }

    public static void writeVarLong(ByteBuf buf, long value) {
        byte part;
        while (true) {
            part = (byte) (value & 0x7F);
            value >>>= 7;
            if (value != 0) {
                part |= 0x80;
            }
            buf.writeByte(part);
            if (value == 0) {
                break;
            }
        }
    }

    public static String readUTF(ByteBuf byteBuf) {
        byte[] bytes = new byte[readVarInt(byteBuf)];
        byteBuf.readBytes(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static void writeUTF(ByteBuf byteBuf, String utf) {
        byte[] data = utf.getBytes(StandardCharsets.UTF_8);
        writeVarInt(byteBuf, utf.length());
        byteBuf.writeBytes(data);
    }

    public static String[] readStringArray(ByteBuf byteBuf){
        int count = readVarInt(byteBuf);
        String[] entries = new String[count];
        for (int i = 0; i < count; i++){
            entries[i] = ByteBufUtils.readUTF(byteBuf);
        }

        return entries;
    }

    public static void writeStringArray(ByteBuf byteBuf, String[] array){
        ByteBufUtils.writeVarInt(byteBuf, array.length);
        for (String string : array){
            ByteBufUtils.writeUTF(byteBuf, string);
        }
    }
}
