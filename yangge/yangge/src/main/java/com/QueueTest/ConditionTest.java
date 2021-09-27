package com.QueueTest;


import org.omg.CORBA.DATA_CONVERSION;
import sun.dc.pr.PRError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class data{
    private volatile int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void go1(){
        lock.lock();
        try{
            while(num != 1){
                 try {
                     condition1.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

            }
             for (int i = 0; i < 5; i++) {
                 System.out.println(Thread.currentThread().getName()+" : 执行操作  "+i);
             }
             num = 2;
             condition2.signal();
         }catch (Exception e){
             e.printStackTrace();
         }finally {
            lock.unlock();
         }
    }

    public void go2(){
        lock.lock();
        try{
            while(num != 2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" : 执行操作  "+i);
            }
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void go3(){
        lock.lock();
        try{
            while(num != 3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+" : 执行操作  "+i);
            }
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}

public class ConditionTest {
    public static void main(String[] args) {
        data data = new data();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    data.go1();
                    System.out.println("---------------------------------------");
                }
            },"A").start();

            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    data.go2();
                    System.out.println("---------------------------------------");
                }

            },"B").start();

            new Thread(()->{
                for (int i = 0; i < 15; i++) {
                    data.go3();
                    System.out.println("---------------------------------------");
                }
            },"C").start();
        }


}
