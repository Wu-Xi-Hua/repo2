package com.CollectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {
    /**
     * java.util.ConcurrentModificationException
     * Collecitons
     * CopyOnWriteArrayList   ---lock锁
     * @param args
     */
    public static void main(String[] args) {

        CopyOnWriteArrayList<Object> onWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                onWriteArrayList.add(UUID.randomUUID().toString().substring(0,8));

            },i+"").start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(onWriteArrayList);

        System.out.println("-------------------------------------------------------------------");
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 30; i++) {
             new Thread(()->{
                   list.add(UUID.randomUUID().toString().substring(0,8));

             },i+"").start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(list);
    }
}
