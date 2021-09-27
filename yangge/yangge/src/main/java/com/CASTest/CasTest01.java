package com.CASTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 比较并交换
 */
public class CasTest01 {
    public static void main(String[] args) {
        //原子integer
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5,6);
        atomicInteger.compareAndSet(5,8);
        System.out.println(atomicInteger.get());

    }
}
