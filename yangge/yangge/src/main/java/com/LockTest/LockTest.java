package com.LockTest;

import com.TransferValue.Person;

/**
 * 可重入锁
 */
public class LockTest {
    public static void main(String[] args) {
        Person person = new Person();
//        new Thread(()->{
//             person.sendEmail();
//        },"aa").start();
//
//        new Thread(()->{
//            person.sendEmail();
//        },"bb").start();

        Thread thread = new Thread(person);
        Thread thread2 = new Thread(person);
        thread.setName("cc");
        thread.start();
        thread2.setName("dd");
        thread2.start();
    }
}
