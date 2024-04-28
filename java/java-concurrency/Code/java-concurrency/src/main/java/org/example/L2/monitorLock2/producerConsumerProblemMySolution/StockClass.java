package org.example.L2.monitorLock2.producerConsumerProblemMySolution;

import java.util.PriorityQueue;
import java.util.Queue;

public class StockClass {

    public static Queue<Integer> queue = new PriorityQueue<>();
    public static int size = 0;

    public synchronized void add(Integer i) throws InterruptedException {
        while(size >= 10){
            wait();
        }
        System.out.println("Adding in queue {} "+Thread.currentThread().getName());
        queue.add(i);
        size++;
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while(queue.isEmpty() || size == 0){
            System.out.println("Queue is empty {} "+ Thread.currentThread().getName());
            wait();
        }
            System.out.println("Removing from queue {} "+Thread.currentThread().getName());
            queue.remove();
            size--;
            System.out.println("Removed from queue {} "+Thread.currentThread().getName());
            notifyAll();
    }
}
