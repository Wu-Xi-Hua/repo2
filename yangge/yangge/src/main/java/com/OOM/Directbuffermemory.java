package com.OOM;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * -XX:MaxDirectMemorySize=5m
 */
public class Directbuffermemory {

    public static void main(String[] args) {
        System.out.println(VM.maxDirectMemory()/1024/1024+"m");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100 * 1024 * 1024);
    }
}
