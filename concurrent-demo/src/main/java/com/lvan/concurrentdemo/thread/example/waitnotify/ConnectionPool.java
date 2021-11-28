package com.lvan.concurrentdemo.thread.example.waitnotify;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 数据库连接池。
 *
 * @author Lvan
 * @since 2021/11/28
 */
public class ConnectionPool {

    /**
     * 定义连接池队列
     */
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                //连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            //小于等于0，不做超时等待处理
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                //当连接池为空，并且还没有超时，则需要阻塞等待
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
