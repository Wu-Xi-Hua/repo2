package com.CollectionTest;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurremtHashMap --->synchronized
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i=1;i<=30;i++){
            new Thread(()->{
                concurrentHashMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(concurrentHashMap);
            },i+"").start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(concurrentHashMap);
    }

}
