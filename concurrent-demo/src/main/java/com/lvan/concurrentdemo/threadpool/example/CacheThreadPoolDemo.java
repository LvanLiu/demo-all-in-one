package com.lvan.concurrentdemo.threadpool.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lvan
 * @date 2021/11/29
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TargetTask());
        }

        executorService.shutdown();
    }
}
