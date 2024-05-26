package org.example.L10;

public class MainClass {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Printing from thread");
        });


    }


}
