package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        log.info("{} run", Thread.currentThread().getName());
    }
}
