package com.QueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 返回结果的
 */
public class QueueTestOfferAndPoll {



    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        boolean offer = blockingQueue.offer(1);
        boolean offer1 = blockingQueue.offer(2);
        boolean offer2 = blockingQueue.offer(3);
        boolean offer3 = blockingQueue.offer(4);
        System.out.println(offer+" "+offer1+" "+offer2+" "+offer3);
        Object poll = blockingQueue.poll();
        Object poll1 = blockingQueue.poll();
        Object poll2 = blockingQueue.poll();
        Object poll3 = blockingQueue.poll();
        System.out.println(poll+" "+poll1+" "+poll2+" "+poll3);

    }
}
