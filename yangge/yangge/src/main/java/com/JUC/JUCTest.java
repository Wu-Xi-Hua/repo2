package com.JUC;

import java.util.concurrent.locks.ReentrantLock;

public class JUCTest {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
