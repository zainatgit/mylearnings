package org.example.L4.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Produce Lock acquired by : "+Thread.currentThread().getName());
            if(isAvailable){
                //already availble, thread has to wait for it to consume.
                System.out.println("Produce thread is waiting : " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Produce lock release by : "+Thread.currentThread().getName());
        }
    }

    public void consume(){
        try{
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consume Lock acquired by : "+Thread.currentThread().getName());
            if(!isAvailable){
                //already not available, thread has to wait for it to produced
                System.out.println("Consumer thread is waiting : "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
            System.out.println("Consume Lock release by : "+Thread.currentThread().getName());
        }
    }


}
