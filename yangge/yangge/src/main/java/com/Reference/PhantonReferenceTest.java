package com.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 */
public class PhantonReferenceTest {
    public static void main(String[] args) {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> objectPhantomReference = new PhantomReference<>(object,referenceQueue);
        System.out.println(object);
        System.out.println(objectPhantomReference.get());
        System.out.println(referenceQueue.poll());
        object = null;
        System.gc();
        System.out.println("-------------------------");
        System.out.println(object);
        System.out.println(objectPhantomReference.get());
        System.out.println(referenceQueue.poll());

    }


}
