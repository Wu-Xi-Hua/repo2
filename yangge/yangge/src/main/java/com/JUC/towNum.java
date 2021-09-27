package com.JUC;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.Arrays;
import java.util.HashMap;

public class towNum {

    public static void main(String[] args) {
        int [] num = {2,5,12,15};
        int target=17;

        int[] go = go2(num, target);
        if(go!=null){
            for (int i:go) {
                System.out.println(i);
            }
        }
    }



    static int[] go2(int [] num,int taget){
        HashMap<Integer, Integer> map = new HashMap<>();
         for(int i=0;i<num.length-1;i++){
              int varialbe = taget-num[i];
              if(map.containsKey(varialbe)){
                   return new int[]{map.get(varialbe),i};
              }
              map.put(num[i],i);
         }
         return null;
    }



    static int[] go(int [] num,int taget){
        for(int i=0;i<num.length-1;i++){
              for(int j=i+1;j< num.length-1;j++){
                  if((taget-num[i])==num[j]){
                      System.out.println("----");
                        return new int[]{i,j};
                  }
              }
        }
        return null;
    }

}
