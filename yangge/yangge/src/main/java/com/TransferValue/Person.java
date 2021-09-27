package com.TransferValue;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
public class Person implements  Runnable {
    public ReentrantLock lock = new ReentrantLock();
    private  String name;
    private Integer age;

    public  Person(Integer age){
      this.age = age;
    }


    /**
     * synchronized
     */
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发送email");
        this.sendeEMS();
    }

    public synchronized void sendeEMS(){
        System.out.println(Thread.currentThread().getName()+"发送ems");
    }

    /**
     * lock
     */
    @Override
    public void run() {
        this.set();
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"       set");
            this.get();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"      get");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
