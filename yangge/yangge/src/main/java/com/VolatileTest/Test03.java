package com.VolatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile禁止指令重排
 */
 class myData3{
    volatile boolean  flag = true;
    volatile int i = 0;
   public void method1(){
//       this.i = 1;
       this.i = 1;
       try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
       this.flag = false;
   }
   public void method2(){
       if(!flag){
           i = i+5;
           System.out.println(Thread.currentThread().getName()+":"+i);
       }
   }
}
public class Test03 {
    public static void main(String[] args) {
        myData3 myData3 = new myData3();
            new Thread(() -> {
                myData3.method1();
            }, "aa").start();

            new Thread(() -> {
                myData3.method2();
            }, "bb").start();
    }
}
