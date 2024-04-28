package org.example.L2.monitorLock2.producerConsumerProblemMySolution;

public class ProducerThread extends Thread{

    StockClass stockClass;
    ProducerThread(StockClass obj){
        this.stockClass = obj;
    }

    @Override
    public void run() {
        try {
            stockClass.add(999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
