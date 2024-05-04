package org.example.L4.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ReentranctLockExample resource1 = new ReentranctLockExample();
        Thread t1 = new Thread(() -> {
            resource1.process(lock);
        });
        ReentranctLockExample resource2 = new ReentranctLockExample();
        Thread t2 = new Thread(() -> {
            resource2.process(lock);
        });

        t1.start();
        t2.start();
        //Here we are passing two different objects still locking is done precisly due to common lock
    }
}
