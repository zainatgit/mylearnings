package org.example.L4.stampedLock;

public class MainClass {
    public static void main(String[] args) {
        StampedLockExample obj = new StampedLockExample();
        Thread t1 = new Thread(()-> {
            obj.producer();
        });

        Thread t2 = new Thread(()->{
            obj.producer();
        });

        Thread t3 = new Thread(()->{
            obj.consumer();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
