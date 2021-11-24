package com.lvan.concurrentdemo.threadexample;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lvan
 * @date 2021/11/23
 */
class ThreadSleepDemoTest {

    @Test
    void sleepTest() throws Exception {

        ThreadSleepDemo threadSleepDemo = new ThreadSleepDemo("thread sleep");
        threadSleepDemo.start();

        threadSleepDemo.join();
    }

    @Test
    void interruptTest() throws Exception {

        ThreadSleepDemo threadSleepDemo = new ThreadSleepDemo("interrupt-thread");
        threadSleepDemo.start();

        TimeUnit.SECONDS.sleep(5);

        threadSleepDemo.interrupt();
    }
}