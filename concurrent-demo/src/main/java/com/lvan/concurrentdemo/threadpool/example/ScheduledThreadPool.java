package com.lvan.concurrentdemo.threadpool.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lvan
 * @date 2021/11/29
 */
public class ScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 2; i++) {
            //
            executorService.scheduleAtFixedRate(new TargetTask(), 0, 500, TimeUnit.MILLISECONDS);
        }

        TimeUnit.SECONDS.sleep(100);
        executorService.shutdown();
    }
}
