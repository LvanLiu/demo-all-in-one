package com.lvan.concurrentdemo.thread.example.waitnotify;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lvan
 * @since 2021/11/28
 */
class ConnectPoolTest {

    /**
     * 预创建10个连接
     */
    static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有ConnectionRunner能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);
    /**
     * main线程将会等待所有ConnectionRunner线程执行完毕
     */
    static CountDownLatch end;

    @Test
    void test() throws InterruptedException {

        //线程数量
        int threadCount = 1000;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got, notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}