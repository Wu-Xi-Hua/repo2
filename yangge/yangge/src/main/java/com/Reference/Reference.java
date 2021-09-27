package com.Reference;


/**
 * 强引用
 */
public class Reference {

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = object1;
        object1 = null;
        System.gc();
        System.out.println(object2);

    }
}
