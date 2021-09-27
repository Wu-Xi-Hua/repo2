package com.TransferValue;

/**
 * jvm内存结构
 */
public class TransferValueTest {

    public void methods1(Integer age){
         age = 11;
    }
    public void methods2(String name){
         name = "xx";
    }
    public void  methods3(Person person){
         person.setName("zs");
    }
    public static void main(String[] args) {
        TransferValueTest transferValueTest = new TransferValueTest();
        int age = 100;
        transferValueTest.methods1(age);
        System.out.println(age);
        System.out.println("--------------");
        String str="abc";
        transferValueTest.methods2(str);
        System.out.println(str);
        System.out.println("----------");
        Person person = new Person();
        person.setName("ls");
        transferValueTest.methods3(person);
        System.out.println(person.getName());


    }

}
