package com.LockTest;

import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁/共享锁
 */
public class ReentrantReadWriterLockTest {
   private HashMap<String,String> hashMap =  new HashMap();
   private ReentrantReadWriteLock lock = new  ReentrantReadWriteLock();

   public void add(String key ,String value){
        lock.writeLock().lock();
         try {
             System.out.println(Thread.currentThread().getName()+"写入中。。。。"+key);
             try { TimeUnit.MICROSECONDS.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}
             hashMap.put(key,value);
             System.out.println(Thread.currentThread().getName()+"写入完成。。。。"+key);
         }catch (Exception e){
               e.printStackTrace();
         }finally {
             lock.writeLock().unlock();
         }

   }
   public void get(String key){
        lock.readLock().lock();
         try {
             System.out.println(Thread.currentThread().getName()+"正在读取。。。"+key);
             String result = hashMap.get(key);
             try { TimeUnit.MICROSECONDS.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
             System.out.println(Thread.currentThread().getName()+"正在读取完成。。。"+result);
         }catch (Exception e){
               e.printStackTrace();
         }finally {
             lock.readLock().unlock();
         }


   }

    public static void main(String[] args) {
        ReentrantReadWriterLockTest readWriterLockTest = new ReentrantReadWriterLockTest();
        for(int i= 1;i<=5;i++){
            final int  index = i;
            new Thread(()->{
                try { TimeUnit.MICROSECONDS.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
                 readWriterLockTest.add(index+"",index+"");
            },i+"").start();
        }
        while(Thread.activeCount()>2){

        }
        for(int i= 1;i<=5;i++){
            final int  index = i;
            new Thread(()->{
                readWriterLockTest.get(index + "");
            },i+"").start();
        }
    }
}
