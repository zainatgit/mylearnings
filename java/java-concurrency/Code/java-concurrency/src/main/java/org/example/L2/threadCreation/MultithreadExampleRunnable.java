package org.example.L2.threadCreation;

public class MultithreadExampleRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Running thread " + Thread.currentThread().getName());
    }
}
