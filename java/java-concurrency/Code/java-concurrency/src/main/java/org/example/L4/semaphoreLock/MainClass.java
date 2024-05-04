package org.example.L4.semaphoreLock;

public class MainClass {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(()-> {
            obj.producer();
        });
        Thread t2 = new Thread(()-> {
            obj.producer();
        });
        Thread t3 = new Thread(()-> {
            obj.producer();
        });
        Thread t4 = new Thread(()-> {
            obj.producer();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }
}
