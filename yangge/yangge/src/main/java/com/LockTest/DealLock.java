package com.LockTest;
import java.util.concurrent.TimeUnit;

class myDealLock implements  Runnable{
    private String lock1;
    private String lock2;

    myDealLock(String lock1 ,String lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+" 获取"+lock1+"锁,尝试获取"+lock2);
            try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            synchronized (lock2){
                System.out.println("获取"+lock2+"锁");
            }
        }
    }
}

public class DealLock {

    public static void main(String[] args) {
            String  lockA = "lockA";
            String  lockB = "lockB";
        System.out.println("aaaaaaa");
        new Thread(new myDealLock(lockA,lockB),"aa").start();
        new Thread(new myDealLock(lockB,lockA),"aa").start();

    }
}
