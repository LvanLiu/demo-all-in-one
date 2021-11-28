package com.lvan.concurrentdemo.threadpool.example;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lvan
 * @since 2021/11/28
 */
@Slf4j
public class SingleThreadPoolDemo {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TargetTask());
        }

        executorService.shutdown();
    }

    static class TargetTask implements Runnable {
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
}
