package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author lvan
 * @date 2021/11/23
 */
@Slf4j
public class ThreadSleepDemo extends Thread{

    public ThreadSleepDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1800 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
