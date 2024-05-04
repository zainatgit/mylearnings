package org.example.L4.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {

    int a = 10;
    StampedLock stampedLock = new StampedLock();

    public void producer(){
        long stamp = stampedLock.tryOptimisticRead();
        try{
            System.out.println("Optimistic Read Lock acquired by : "+Thread.currentThread().getName());
            a=11;
            Thread.sleep(8000);
            if(stampedLock.validate(stamp)){
                System.out.println("updated a value successfully");
            }
            else {
                System.out.println("Rollback of work");
                a=10; //rollback
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void consumer(){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println("Write Lock acquired by : "+Thread.currentThread().getName());
            a=9;
        }
        finally {
            stampedLock.unlock(stamp);
            System.out.println("Write lock released by : "+Thread.currentThread().getName());
        }
    }

    public void produce() {
    }
}
