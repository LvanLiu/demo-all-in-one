package com.lvan.concurrentdemo.volatileexample;

/**
 * @author Lvan
 * @since 2021/11/9
 */
public class VolatileExample {
    private int a = 0;
    private volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a;
        }
    }
}
