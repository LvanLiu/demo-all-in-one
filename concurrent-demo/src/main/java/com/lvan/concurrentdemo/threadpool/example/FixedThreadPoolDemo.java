package com.lvan.concurrentdemo.threadpool.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lvan
 * @since 2021/11/28
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TargetTask());
        }

        executorService.shutdown();
    }
}
