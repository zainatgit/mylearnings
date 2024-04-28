package org.example.L2.threadCreation;

public class L2MainClass {
    public static void main(String[] args) {
        MultithreadExampleRunnable m = new MultithreadExampleRunnable();
        Thread t1 = new Thread(m);
        t1.start();
        MultithreadExampleExtends m2 = new MultithreadExampleExtends();
        m2.start();
        System.out.println("Finished Running " + Thread.currentThread().getName());
    }
}
