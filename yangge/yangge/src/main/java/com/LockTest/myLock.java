package com.LockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class myLock {
   private AtomicReference<Thread>  atomicReference=  new AtomicReference();

   public void lock(){
       Thread thread = Thread.currentThread();
       while(!atomicReference.compareAndSet(null,thread)){

       }
       System.out.println(Thread.currentThread().getName()+"----lock");
   }

   public void unLock(){
       Thread thread = Thread.currentThread();

       atomicReference.compareAndSet(thread,null);
       System.out.println(Thread.currentThread().getName()+"----unlock");
   }

    public static void main(String[] args) {
        myLock myLock = new myLock();

        new Thread(()->{
            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            myLock.lock();
             System.out.println(Thread.currentThread().getName()+"运行");
              try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
             System.out.println(Thread.currentThread().getName()+"结束");
            myLock.unLock();
        },"aa").start();


//       try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            myLock.lock();
            System.out.println(Thread.currentThread().getName()+"运行");
            try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"结束");
            myLock.unLock();
        },"bb").start();
    }

}
