package com.CollectionTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriterArraySet -->CopyOnWriterArrayList  -->lock
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet<String> onWriteArraySet = new CopyOnWriteArraySet<>(new HashSet<>());
       for (int i=1;i<=30;i++){
           new Thread(()->{
               synchronizedSet.add(UUID.randomUUID().toString().substring(0,8));
               System.out.println(synchronizedSet);
           },i+"").start();
       }
       while(Thread.activeCount()>2){

       }
        System.out.println("---------------------------------");
        System.out.println(synchronizedSet);
    }


}
