package com.lvan.concurrentdemo.threadpool.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lvan
 * @since 2021/11/28
 */
@Slf4j
public class SingleThreadPoolDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TargetTask());
        }

        executorService.shutdown();
    }
}
