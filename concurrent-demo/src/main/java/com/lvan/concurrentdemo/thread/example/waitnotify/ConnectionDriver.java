package com.lvan.concurrentdemo.thread.example.waitnotify;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 自定义连接驱动。
 *
 * @author Lvan
 * @since 2021/11/28
 */
public class ConnectionDriver {

    public static Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class[]{Connection.class}, new ConnectionHandler());
    }

    /**
     *
     */
    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MICROSECONDS.sleep(100);
            }
            return null;
        }
    }
}
