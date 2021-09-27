package com.CGTest;


import java.util.concurrent.TimeUnit;

public class hello {
    public static void main(String[] args) {

        System.out.println("helloGC");
        try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
