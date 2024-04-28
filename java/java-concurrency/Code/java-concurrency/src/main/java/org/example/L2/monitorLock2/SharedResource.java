package org.example.L2.monitorLock2;

public class SharedResource {

    boolean itemAvailable = false;
    public static int counter = 0;

    public synchronized void addItem(){
        System.out.println("Adding item by {} "+Thread.currentThread().getName());
        itemAvailable = true;
        counter++;
        System.out.println("Item added by {} "+Thread.currentThread().getName());
        notifyAll(); //Releases monitor lock
    }

    public synchronized void consumeItem() throws InterruptedException {
        System.out.println("Starting to consume item {} "+Thread.currentThread().getName());
        // if condition could have been used but to avoid "spurious wake-up" call, while condition is used.
        while(!itemAvailable){
            System.out.println("Item is not available .. waiting");
            wait(); //releases monitor lock
        }
        System.out.println("Item consumed by "+Thread.currentThread().getName());
        itemAvailable = false;
        counter--;
    }

}
