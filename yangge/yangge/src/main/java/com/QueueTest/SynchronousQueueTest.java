package com.QueueTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {


    public static void main(String[] args) {

        BlockingQueue synchronousQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName()+" : 添加  "+1);
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName()+" : 添加  "+2);
                synchronousQueue.put(3);
                System.out.println(Thread.currentThread().getName()+" : 添加  "+3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bb").start();
       new Thread(()->{
           try {
               try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
               System.out.println(Thread.currentThread().getName()+" : 获取 "+synchronousQueue.take());
               try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
               System.out.println(Thread.currentThread().getName()+" : 获取 "+synchronousQueue.take());
               try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
               System.out.println(Thread.currentThread().getName()+" : 获取 "+synchronousQueue.take());
               try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       },"aa").start();
    }
}
