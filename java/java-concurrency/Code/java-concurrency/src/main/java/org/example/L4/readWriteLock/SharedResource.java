package org.example.L4.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){
        try{
            //In place where we use read lock we are not supposed to change any values, its just meant for
            //reading
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: "+Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (Exception e){

        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read lock release by : "+Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by : "+Thread.currentThread().getName());
            isAvailable = false;
        }catch (Exception e){

        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write lock acquired by : "+Thread.currentThread().getName());

        }
    }
}
