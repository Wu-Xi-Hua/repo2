package com.Reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap的key如果不为引用类型，gc后，该元素不会消失
 */
public class WeakHashMapTest {

    public static void main(String[] args) {

        WeakHashMap<Integer, String> map = new WeakHashMap<>();
//        Integer key = new Integer(2);
        Integer key = 1;

        String name = "weakhashmap";

        map.put(key,name);

        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"    "+map.size());
    }


//
//    public static void main(String[] args) {
//        HashMap<Object, Object> map = new HashMap<>();
//        Integer key = 1;
//        String name = "hashmap";
//        map.put(key,name);
//        System.out.println(map);
//        key = null;
//        System.out.println(map);
//        System.gc();
//        System.out.println(map);
//    }
}
