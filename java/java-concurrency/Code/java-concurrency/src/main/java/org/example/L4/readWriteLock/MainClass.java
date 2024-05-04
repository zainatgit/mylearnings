package org.example.L4.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread( () -> {
            sharedResource.producer(readWriteLock);
        });

        Thread t2 = new Thread( () -> {
            sharedResource.producer(readWriteLock);
        });

        SharedResource sharedResource2 = new SharedResource();

        Thread t3 = new Thread( ()-> {
            sharedResource2.consumer(readWriteLock);
        });

        t1.start();
        t2.start();
        t3.start();


    }
}
