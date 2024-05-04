package org.example.L3;

public class DaemonExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main is started");
        Thread t1 = new Thread(()-> {
            System.out.println("t1 started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 ends");
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main is finished");
    }
}
