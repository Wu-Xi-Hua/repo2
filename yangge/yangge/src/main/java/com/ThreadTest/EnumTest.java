package com.ThreadTest;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum EnumTest {
    one("1","赵"),
    tow("2","魏"),
    three("3","韩"),
    four("4","齐"),
    five("5","楚"),
    six("6","燕");

    private String name;
    private String message;

     EnumTest(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public static String getMessageByName(String name){
        EnumTest[] values = EnumTest.values();
        for (EnumTest enumTest :values) {
            if(enumTest.getName().equals(name)){
               return enumTest.getMessage();
            }
        }
        return null;
    }
}
