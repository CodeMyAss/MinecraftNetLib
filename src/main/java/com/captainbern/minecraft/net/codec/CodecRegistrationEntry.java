package com.captainbern.minecraft.net.codec;

public class CodecRegistrationEntry {

    private final int opcode;
    private final Codec<?> codec;

    public CodecRegistrationEntry(int opcode, Codec codec) {
        this.opcode = opcode;
        this.codec = codec;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Codec getCodec() {
        return this.codec;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CodecRegistrationEntry))
            return false;

        if (other == this)
            return true;

        CodecRegistrationEntry otherRegistration = ((CodecRegistrationEntry) other);

        return ((CodecRegistrationEntry) other).getOpcode() == this.opcode && ((CodecRegistrationEntry) other).getCodec().equals(this.codec);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + this.opcode;
        hash = hash * 31 + this.codec.hashCode();
        return hash;
    }
}
