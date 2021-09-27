package com.QueueTest;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者与消费者
 */
class shareData{
    private volatile  int num = 0;
    private Lock lock =  new ReentrantLock();
    //精确唤醒
    private Condition condition = lock.newCondition();
    //生产
    public void producer(){
         lock.lock();
          try {
              while(num != 0){
                  //不生产
                  try {
                      condition.await();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
              //生产
              num++;
              System.out.println(Thread.currentThread().getName()+" 生产了"+num);
              condition.signalAll();
          }catch (Exception e){
                e.printStackTrace();
          }finally {
              lock.unlock();
          }


    }
    //消费
    public void consumer(){
         lock.lock();
          try {

              while(num == 0){
                  //不消费
                  try {
                      condition.await();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
              //消费
              num--;
              System.out.println(Thread.currentThread().getName()+" 消费了"+num);
              condition.signalAll();

          }catch (Exception e){
                e.printStackTrace();
          }finally {
              lock.unlock();
          }


    }

}

public class producerAndConsumer {
    public static void main(String[] args) {
        shareData shareData = new shareData();
        new Thread(()->{
               for (int i=1;i<=5;i++){
                  shareData.producer();
               }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.consumer();
            }
        },"bb").start();

    }



}
