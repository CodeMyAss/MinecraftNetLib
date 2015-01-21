package com.captainbern.minecraft.game.nbt;

public class NbtReadLimiter {

    private final long maxAllocatedBytes;
    private long allocatedBytes;

    public NbtReadLimiter(long maxAllocatedBytes) {
        this.maxAllocatedBytes = maxAllocatedBytes;
    }

    public void allocate(long amount) {
        this.allocatedBytes += amount / 8l;

        if (this.allocatedBytes > this.maxAllocatedBytes)
            throw new RuntimeException("Tried to read NbtTag that was too big. Allocated bytes: " + this.allocatedBytes + " maximum allowed bytes: " + this.maxAllocatedBytes);
    }

    public static NbtReadLimiter getInfiniteReadLimiter() {
        return new NbtReadLimiter(0l) {
            @Override
            public void allocate(long amount) {}
        };
    }
}
