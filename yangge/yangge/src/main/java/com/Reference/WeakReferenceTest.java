package com.Reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        Object object1 = new Object();
        WeakReference weakReference = new WeakReference(object1);
        object1 = null;
        System.gc();
        System.out.println(object1);
        System.out.println(weakReference.get());
    }
}
