package com.OOM;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

public class StackOverError {

    public  void stackOver(){
          stackOver();
    }

    public static void main(String[] args) {
        StackOverError stackOverError = new StackOverError();
        stackOverError.stackOver();

    }
}
