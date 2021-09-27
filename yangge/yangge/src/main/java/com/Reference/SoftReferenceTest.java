package com.Reference;

import java.lang.ref.SoftReference;

/**
 * 软引用    -Xms5m -Xmx5m -XX:+PrintGCDetails
 */
public class SoftReferenceTest {

    public static void main(String[] args) {

        Object object1 = new Object();
        SoftReference softReference = new SoftReference<>(object1);
        System.out.println(object1);
        System.out.println(softReference.get());
        System.out.println("---------------");
        object1 = null;
        try{
            Byte[] bytes = new Byte[5*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(object1);
            System.out.println(softReference.get());
        }



    }


//    public static void main(String[] args) {
//
//        Object object1 = new Object();
//        SoftReference softReference = new SoftReference<>(object1);
//        System.out.println(object1);
//        System.out.println(softReference.get());
//        System.out.println("---------------");
//        object1 = null;
//        System.gc();
//        System.out.println(object1);
//        System.out.println(softReference.get());
//
//    }


}
