package com.JUC;

public class intern {
    public static void main(String[] args) {

        String s1 = new StringBuilder("la").append("go").toString();
        String s2 = s1.intern();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);
        System.out.println();
        String js = new StringBuffer("ja").append("va").toString();
        String js2 = js.intern();
        System.out.println(js);
        System.out.println(js2);
        System.out.println(js==js2);


    }


}
