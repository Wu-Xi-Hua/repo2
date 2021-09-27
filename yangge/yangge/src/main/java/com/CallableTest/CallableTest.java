package com.CallableTest;


import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class myCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return 1024;
    }
}


public class CallableTest {

    public static void main(String[] args) {
        myCallable myCallable = new myCallable();
        FutureTask futureTask = new FutureTask<>(myCallable);
        FutureTask futureTask2 = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask,"aa");
        Thread thread2 = new Thread(futureTask2,"bb");
        thread.start();
        thread2.start();
        try {
            Object o = futureTask.get();
            Object o1 = futureTask2.get();
            System.out.println(Integer.parseInt(o.toString())+100);
            System.out.println(o1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
