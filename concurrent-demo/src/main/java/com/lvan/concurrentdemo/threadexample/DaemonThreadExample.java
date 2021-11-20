package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
public class DaemonThreadExample {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                log.info("thread is run");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        log.info("main thread finished lifecycle");
    }
}
