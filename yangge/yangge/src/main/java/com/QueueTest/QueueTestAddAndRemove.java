package com.QueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 抛出异常的
 */
public class QueueTestAddAndRemove {


    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
//        blockingQueue.add(4);  // Queue full
        Object remove1 = blockingQueue.remove();
        Object remove2 = blockingQueue.remove();
        Object remove3 = blockingQueue.remove();
//        Object remove4 = blockingQueue.remove(); //NoSuchElementException
        System.out.println(remove1+"  "+remove2+"  "+remove3);


    }
}
