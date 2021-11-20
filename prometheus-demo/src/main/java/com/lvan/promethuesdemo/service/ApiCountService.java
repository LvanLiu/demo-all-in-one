package com.lvan.promethuesdemo.service;

/**
 * @author lvan
 * @date 2021/11/17
 */
public interface ApiCountService {

    void increment(String url);

    void increment(String url, Class<?> exceptionClass);

    void increment(String url, Class<?> exceptionClass, String status);
}
