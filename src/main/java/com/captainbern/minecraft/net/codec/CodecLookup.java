package com.captainbern.minecraft.net.codec;

import com.captainbern.minecraft.net.exception.InvalidOpcodeException;
import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.reflection.Reflection;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CodecLookup {

    private final Map<Integer, Codec<?>> CODEC_LOOKUP = Maps.newConcurrentMap();
    private final Map<Class<? extends Packet>, CodecRegistrationEntry> REGISTRATION = Maps.newConcurrentMap();

    private final AtomicInteger NEXT_ID = new AtomicInteger(0);

    public CodecLookup() {
    }

    public <P extends Packet, C extends Codec<? super P>> CodecRegistrationEntry register(int opcode, Class<P> packet, Class<C> codecClass) {
        CodecRegistrationEntry codecRegistration = this.REGISTRATION.get(packet);

        if (codecRegistration != null) {
            return codecRegistration;
        }

        C codec;
        try {
            codec = new Reflection().reflect(codecClass).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create a new instance of class: " + codecClass.getName());
        }

        if (opcode < 0) {
            throw new IllegalArgumentException("Opcode must either be 0 or greater than 0");
        } else {
            int id;
            try {
                do {
                    id = this.NEXT_ID.getAndIncrement();
                } while (get(id) != null);
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException("Failed to assign a valid opcode to packet: " + packet.getCanonicalName());
            }

            opcode = id;
        }

        Codec<?> check = get(opcode);
        if (check != null && check.getClass() != codecClass)
            throw new IllegalStateException("Cannot assign opcode: " + opcode + " to: " + codecClass.getCanonicalName() + ", already assigned to: " + check.getClass().getCanonicalName());

        codecRegistration = new CodecRegistrationEntry(opcode, codec);
        this.register(opcode, codec);
        this.REGISTRATION.put(packet, codecRegistration);

        return codecRegistration;
    }

    private void register(int opcode, Codec<?> codec) {
        this.CODEC_LOOKUP.put(opcode, codec);
    }

    private Codec<?> get(int opcode) {
        return this.CODEC_LOOKUP.get(opcode);
    }

    public Codec<?> getCodecFor(int opcode) throws InvalidOpcodeException {
        try {
            Codec<?> codec = this.CODEC_LOOKUP.get(opcode);

            if (codec == null)
                throw new NullPointerException("Failed to find the codec for opcode: " + opcode);

            return codec;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Failed to find a Codec for opcode: " + opcode);
            return null;
        }
    }

    public <P extends Packet> CodecRegistrationEntry getCodecFor(Class<P> packetClass) {
        return this.REGISTRATION.get(packetClass);
    }

    @Override
    public String toString() {
        return "CodecLookup{packets=" + this.REGISTRATION + ", opcodes=" + this.CODEC_LOOKUP + "}";
    }
}
