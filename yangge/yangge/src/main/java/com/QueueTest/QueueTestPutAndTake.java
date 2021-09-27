package com.QueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞的
 */
public class QueueTestPutAndTake {


    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        try {
            blockingQueue.put(1);
            blockingQueue.put(2);
            blockingQueue.put(3);
//            blockingQueue.put(4);
            Object take = blockingQueue.take();
            Object take1 = blockingQueue.take();
            Object take2 = blockingQueue.take();
            Object take3 = blockingQueue.take();
            System.out.println(take+" "+take1+" "+take2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
