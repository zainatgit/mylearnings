package org.example.L2.monitorLock2;

import java.util.ArrayList;
import java.util.List;

public class MainClass2 {

    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                obj.addItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                obj.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();

        System.out.println("Main class ends");

    }

}
