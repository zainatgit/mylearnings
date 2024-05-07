package org.example.L6.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactoy(),
                new CustomRejectHandler());

        for(int i=1; i<=10; i++){
            int finalI = i;
            executor.submit( () -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task : "+ finalI +" "+Thread.currentThread().getName());
            });
        }

        executor.shutdownNow();



    }
}

//Creating to show that we can also pass customThreadFactory in ThreadPoolExecutor constructor.
class CustomThreadFactoy implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
        System.out.println("Task rejected : "+r.toString());
    }
}
