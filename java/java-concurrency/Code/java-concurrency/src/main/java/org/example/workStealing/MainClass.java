package org.example.workStealing;

import java.util.concurrent.*;

public class MainClass {
    public static void main(String[] args) {
        //ExecutorService workStealing = Executors.newWorkStealingPool();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> future = forkJoinPool.submit(new ComputeSum(0,100));
        //submit() sends to submission queue
        //fork() sends to work-stealing queue
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
