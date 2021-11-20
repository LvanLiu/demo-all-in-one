package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
public class ThreadExample extends Thread {

    public ThreadExample(int threadNo) {
        super("Thread Example-" + threadNo);
    }

    @Override
    public void run() {
        log.info("{} run", getName());
    }
}
