package com.captainbern.minecraft.game.nbt;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NbtCompressedStreamTools {

    private NbtCompressedStreamTools() {
        super();
    }

    public static byte[] toByteArray(NbtTagCompound tagCompound) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream)))) {
            write(tagCompound, (DataOutput) dataOutputStream);
        }

        return byteArrayOutputStream.toByteArray();
    }

    public static void write(NbtTagCompound tagCompound, OutputStream outputStream) throws IOException {

        try (DataOutputStream dataOutput = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(outputStream)))) {
            write(tagCompound, (DataOutput) dataOutput);
        }
    }

    private static void write(NbtTag tag, DataOutput output) throws IOException {
        output.writeByte(tag.getType().getId());
        if (tag.getType() != NbtTagType.TAG_END) {
            output.writeUTF("");
            tag.write(output);
        }
    }

    public static NbtTagCompound read(byte[] bytes) throws IOException {
        return read(bytes, NbtReadLimiter.getInfiniteReadLimiter());
    }

    public static NbtTagCompound read(byte[] bytes, NbtReadLimiter readLimiter) throws IOException {

        NbtTagCompound tagCompound;

        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(bytes))))) {
            tagCompound = read(dataInputStream, readLimiter);
        }

        return tagCompound;
    }

    public static NbtTagCompound read(InputStream inputStream) throws IOException {

        NbtTagCompound tagCompound;

        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream)))) {
            tagCompound = read(dataInputStream);
        }

        return tagCompound;
    }

    public static NbtTagCompound read(DataInputStream inputStream) {
        return read(inputStream, NbtReadLimiter.getInfiniteReadLimiter());
    }

    public static NbtTagCompound read(InputStream inputStream, NbtReadLimiter readLimiter) {
        try {
            NbtTag tag = read(new DataInputStream(inputStream), 0, readLimiter);

            if (tag instanceof NbtTagCompound)
                return (NbtTagCompound) tag;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while reading an NbtTagCompound!", e);
        }

        throw new RuntimeException("Root-tag should be an NbtTagCompound!");
    }

    private static NbtTag read(DataInput input, int depth, NbtReadLimiter readLimiter) throws IOException {
        byte type = input.readByte();

        if (type == 0)
            return new NbtTagEnd();

        input.readUTF();
        NbtTag tag = NbtTagType.getTypeForId(type).newTag();

        tag.load(input, depth, readLimiter);

        return tag;
    }
}
