package org.example.L4.semaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2); //This will permit two threads to acquire the lock simultaneously

    public void producer(){
        try {
            lock.acquire();
            System.out.println("Lock acquired by : "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.release();
            System.out.println("Lock released by : "+Thread.currentThread().getName());
        }
    }


}
