package com.VolatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile的不保证原子性
 * atomicinterger
 */

class myData1{
    public AtomicInteger atomicInteger = new AtomicInteger(0);
    public volatile  int num = 0;
    public void addTo60(){
        num = num+60;
    }
    public void  oldAddPlus(){
        num++;
    }
    public void addplus(){
        atomicInteger.getAndIncrement();
        num = atomicInteger.get();
    }
}

public class Test02 {
    public static void main(String[] args) {
        myData1 myData1 = new myData1();
        for(int i=1;i<=100;i++){
            new Thread(()->{
                for(int j=1;j<=100;j++){
                    myData1.addplus();
                }

            },i+"").start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(Thread.currentThread().getName()+":"+myData1.num);

//        myData1 myData1 = new myData1();
//
//        for (int j = 1; j<=10;j++) {
//            new Thread(()->{
//                for (int i = 1; i<=1000 ;i++){
//                    myData1.addplus();
//                }
//            },"aa").start();
//        }
//       while(Thread.activeCount()>2){
//           Thread.yield();
//       }
//        System.out.println(Thread.currentThread().getName()+"----"+myData1.atomicInteger.get());
    }

}
