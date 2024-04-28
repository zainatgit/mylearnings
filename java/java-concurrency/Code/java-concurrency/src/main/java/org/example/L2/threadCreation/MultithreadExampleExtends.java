package org.example.L2.threadCreation;

public class MultithreadExampleExtends extends Thread{
    @Override
    public void run(){
        System.out.println("Currently running : "+Thread.currentThread().getName());
    }
}
