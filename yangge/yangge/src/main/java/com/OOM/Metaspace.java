package com.OOM;

import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 */
public class Metaspace {
public  static class mydata{}

    public static void main(String[] args) {
          int i = 0;
          try{
              while(true){
                  i++;
                  mydata mydata = new mydata();
              }
          }catch (Exception e){
              System.out.println("总数： "+i);
              e.printStackTrace();
          }finally {

          }

    }
}
