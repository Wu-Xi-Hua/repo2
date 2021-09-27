package com.ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * 减
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1;i<=6;i++){
            new Thread(()->{
                //System.out.println(Thread.currentThread().getName()+"   离开教室");
                System.out.println(Thread.currentThread().getName()+"  被灭");
                countDownLatch.countDown();
            },EnumTest.getMessageByName(i+"")).start();
        }

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"一统华夏");
//            System.out.println(Thread.currentThread().getName()+"关闭教室的门");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
