package org.example.L2.monitorLock2.producerConsumerProblemMySolution;

public class ConsumerThread extends Thread{

    StockClass stockClass;
    ConsumerThread(StockClass obj){
        this.stockClass = obj;
    }

    @Override
    public void run() {
        try {
            stockClass.remove();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
