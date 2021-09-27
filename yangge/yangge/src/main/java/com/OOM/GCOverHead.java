package com.OOM;


import java.util.ArrayList;

/**
 * -Xms10m -Xmx20m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverHead {

    public static void main(String[] args) {
        try{
            int i= 0;
            ArrayList<Object> arrayList = new ArrayList<>();
            while(true){
                arrayList.add(String.valueOf(i++).intern());
            }
        }catch (Exception e){
          e.printStackTrace();
          throw  e;
        }finally {

        }


    }
}
