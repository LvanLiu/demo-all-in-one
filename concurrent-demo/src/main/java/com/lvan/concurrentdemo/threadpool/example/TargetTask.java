package com.lvan.concurrentdemo.threadpool.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lvan
 * @since 2021/11/28
 */
@Slf4j
public class TargetTask implements Runnable {

    static AtomicInteger taskNo = new AtomicInteger(1);
    private String taskName;

    public TargetTask() {
        taskName = "task-" + taskNo.getAndIncrement();
    }

    @Override
    public void run() {
        log.info("task{} is running", taskName);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task {} is finished", taskName);
    }
}