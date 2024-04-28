package org.example.L2.monitorLock2.producerConsumerProblemMySolution;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        StockClass stockClass = new StockClass();
        List<ProducerThread> producerThreadList = new ArrayList<>();
        List<ConsumerThread> consumerThreadList = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            producerThreadList.add(new ProducerThread(stockClass));
            consumerThreadList.add(new ConsumerThread(stockClass));
        }
        for (int i = 0; i <= 10; i++) {
            consumerThreadList.get(i).start();
            producerThreadList.get(i).start();
        }

        //If all works fine then final size should be 0
        System.out.println("Final size "+StockClass.size);
    }
}
