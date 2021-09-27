package com.CASTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class user{
     private  String name;
     private  Integer age;
}
public class CasTest02 {
    public static void main(String[] args) {
        user zs = new user("zs",12);
        user ls = new user("ls", 23);
        user ww = new user("ww", 21);
        //原子引用
        AtomicReference<user> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"----"+userAtomicReference.get());
        //时间戳原子引用
        AtomicStampedReference<user> userAtomicStampedReference = new AtomicStampedReference<user>(zs,1);
        //ABA问题
        new Thread(()->{
            userAtomicStampedReference.compareAndSet(zs,ls,1,2);
            userAtomicStampedReference.compareAndSet(ls,zs,2,3);
        },"aa").start();

       new Thread(()->{
           try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
           int stamp ;
           user newUser;
            do{
                 stamp = userAtomicStampedReference.getStamp();
                 newUser = userAtomicStampedReference.getReference();
            }while(!userAtomicStampedReference.compareAndSet(newUser,ww,stamp,stamp+1));

       },"bb").start();
       while(Thread.activeCount()>2){

       }
        System.out.println("000000000000"+userAtomicStampedReference.getReference()+"---------"+userAtomicStampedReference.getStamp());
    }
}
