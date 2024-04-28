package org.example.L2.monitorLock;

public class MonitorLockMainClass {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread t1 = new Thread(() -> {
            obj.task1();
        });
        Thread t2 = new Thread(() -> {
            obj.task2();
        });
        Thread t3 = new Thread(() -> {
            obj.task3();
        });

        t1.start();//t1 acquires monitor lock
        t2.start();//syncronized part will only get executed when t2 gets lock that is currently with t1
        t3.start();
    }



}
