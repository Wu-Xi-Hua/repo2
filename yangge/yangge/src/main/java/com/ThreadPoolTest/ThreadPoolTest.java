package com.ThreadPoolTest;

import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String[] args) {
        System.out.println("cpu  :   "+Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ThreadPoolExecutor myThreadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,  //合理配置线程池的关键参数
                1l,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try{
            for (int i = 1;i<=10;i++){
//              executorService.execute(()->{
//                  System.out.println(Thread.currentThread().getName() + " 线程执行");
//              });


//                singleThreadExecutor.execute(()->{
//                    System.out.println(Thread.currentThread().getName() + " 线程执行");
//                });

            cachedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + " 线程执行");



            });
             try { TimeUnit.MICROSECONDS.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭线程池
            cachedThreadPool.shutdown();
        }


    }
}
