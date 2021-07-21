package com.harisewak.dsa.datastructures.implementation;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class OffHeapArray {
    final byte BYTE = 1;
    long size;
    long address;

    public OffHeapArray(long size) throws NoSuchFieldException, IllegalAccessException {
        this.size = size;
        address = getUnsafe().allocateMemory(size * BYTE);
    }

    Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public void set(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().putByte(address+i*BYTE, value);
    }

    public byte get(long i) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getByte(address + i * BYTE);
    }

    public long size() {
        return size;
    }

    public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().freeMemory(address);
    }
}
