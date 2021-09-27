package com.OOM;

import java.util.concurrent.TimeUnit;

/**
 * unable to create new native thread
 */
public class UnableToCreateNewNativeThread {

    public static void main(String[] args) {

        for (int i = 0; ; i++) {
             new Thread(()->{
                    try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) {e.printStackTrace();}
             },""+i).start();
        }
    }


}
