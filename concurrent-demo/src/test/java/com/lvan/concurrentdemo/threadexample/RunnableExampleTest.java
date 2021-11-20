package com.lvan.concurrentdemo.threadexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lvan
 * @since 2021/11/20
 */
class RunnableExampleTest {

    @Test
    void run() {

        for (int i = 0; i < 2; i++) {
            RunnableExample runnableExample = new RunnableExample();
            Thread thread = new Thread(runnableExample, "Thread Example-" + i);
            thread.start();
        }
    }

    @Test
    void runnable() {

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }, "Thread Example-" + i);
            thread.start();
        }
    }
}