package com.QueueTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 有时间限制的
 */
public class QueueTestOfferAndPollTime {



    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        try {
            boolean offer =  blockingQueue.offer(1,2, TimeUnit.SECONDS);
            boolean offer1 = blockingQueue.offer(2,2, TimeUnit.SECONDS);
            boolean offer2 = blockingQueue.offer(3,2, TimeUnit.SECONDS);
            Object poll = blockingQueue.poll(2, TimeUnit.SECONDS);
            boolean offer3 = blockingQueue.offer(4,2, TimeUnit.SECONDS);
            System.out.println(offer+" "+offer1+" "+offer2+" "+offer3);
            System.out.println("获取： "+poll);
//            Object poll = blockingQueue.poll();
//            Object poll1 = blockingQueue.poll();
//            Object poll2 = blockingQueue.poll();
//            Object poll3 = blockingQueue.poll();
//            System.out.println(poll+" "+poll1+" "+poll2+" "+poll3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
