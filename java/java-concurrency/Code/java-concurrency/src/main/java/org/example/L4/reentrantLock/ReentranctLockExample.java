package org.example.L4.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranctLockExample {

    boolean isAvailable = false;

    public void process(ReentrantLock lock){
        try{
            lock.lock(); //Acquires lock
            System.out.println("Lock acquired by : "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }catch (Exception e){

        }finally {
            System.out.println("Lock release by : "+Thread.currentThread().getName());
            lock.unlock();
        }

    }
}
