package com.VolatileTest;

import java.util.concurrent.TimeUnit;

/**
 * volatile的可见性
 */
class myData{
    public volatile int num = 0;
    public void addTo60(){
        num = num+60;
    }
}

public class Test01 {

    public static void main(String[] args) {

        myData myData = new myData();
        new Thread(()->{
             myData.addTo60();
            System.out.println(Thread.currentThread().getName()+":"+myData.num);
        },"aa").start();
       try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(Thread.currentThread().getName()+":"+myData.num);


//        myData mydata = new myData();
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"come in");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                mydata.addTo60();
//            System.out.println(Thread.currentThread().getName()+mydata.num);
//        },"aa").start();
//
//         while(mydata.num == 0){
//
//         }
//        System.out.println(Thread.currentThread().getName()+"----"+mydata.num);
    }


}
