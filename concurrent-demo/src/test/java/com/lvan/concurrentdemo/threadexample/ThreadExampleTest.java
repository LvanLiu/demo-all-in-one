package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
class ThreadExampleTest {

    @Test
    void run() {

        for (int i = 0; i < 2; i++) {
            ThreadExample threadExample = new ThreadExample(i);
            threadExample.start();
        }

        log.info("end");
    }
}