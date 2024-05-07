package org.example.L7;

import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //Passing callable
        Future<String> future = executor.submit(() -> {
            Thread.sleep(3000);
            return "Job done";
        });
        System.out.println("Starting future");
        System.out.println(future.get());
        System.out.println("Closing main");
        executor.shutdown();

    }
}
