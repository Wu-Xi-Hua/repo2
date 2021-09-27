package com.VolatileTest;

/**
 * 多线程下的单例模式
 */
public class SingletonDemo {
    //volatile防止禁止指令重排序
   private static   SingletonDemo singletonDemo = null;
   public SingletonDemo(){
       System.out.println(Thread.currentThread().getName()+"构造器-------------");
   }

    /**
     * DCL双端检索机制
     * 返回对象
     * @return
     */
   public static SingletonDemo getSingletonDemo() {
       if(singletonDemo == null){
       synchronized (SingletonDemo.class) {
           if (singletonDemo == null) {
               singletonDemo = new SingletonDemo();
           }
       }
   }
       return singletonDemo;
   }

    public static void main(String[] args) {

        for (int i = 1;i<=10;i++){
           new Thread(()->{
               SingletonDemo singletonDemo1 = SingletonDemo.getSingletonDemo();
               System.out.println(Thread.currentThread().getName()+"------------------"+singletonDemo1);
           },i+"").start();
       }

    }
}
