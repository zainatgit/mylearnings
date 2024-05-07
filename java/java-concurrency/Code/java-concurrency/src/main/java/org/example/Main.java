package org.example;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        integer.incrementAndGet();
        System.out.println("Hello world!");
    }
}