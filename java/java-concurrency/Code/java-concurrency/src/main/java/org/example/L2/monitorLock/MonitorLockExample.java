package org.example.L2.monitorLock;

public class MonitorLockExample {

    public synchronized void task1(){
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("completed task1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("inside task2, but before syncronized");
        synchronized (this){ //this means instance of object that is being used to invoke this method
            System.out.println("inside task2, inside syncronized");
        }
    }

    public void task3(){
        System.out.println("inside task3 unsyncronized");
    }
}
