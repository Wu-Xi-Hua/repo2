package com.OOM;

/**
 * -Xms10m -Xmx20m
 */
public class JavaHeapError {


    public static void main(String[] args) {


        Byte[] bytes = new Byte[1014*10*10*1024];

    }
}
