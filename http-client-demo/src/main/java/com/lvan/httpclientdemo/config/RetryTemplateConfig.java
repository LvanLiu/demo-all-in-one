package com.lvan.httpclientdemo.config;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.NeverRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lvan
 * @since 2021/11/21
 */
@Configuration
public class RetryTemplateConfig {

    @Bean
    public RetryTemplate retryTemplate() {

        RetryTemplate retryTemplate = new RetryTemplate();

        //设置退避策略
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy());
        retryTemplate.setRetryPolicy(simpleRetryPolicy());

        return retryTemplate;
    }

    /**
     * 重试指定次数的策略，比较常用
     */
    private RetryPolicy simpleRetryPolicy() {

        Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<>(4);
        retryableExceptions.put(IOException.class, true);
        retryableExceptions.put(ForestRuntimeException.class, true);

        return new SimpleRetryPolicy(2, retryableExceptions);
    }

    /**
     * 指定异常重试策略。
     */
    private RetryPolicy exceptionClassifierRetryPolicy() {
        Map<Class<? extends Throwable>, RetryPolicy> map = new HashMap<>();
        map.put(Exception.class, new NeverRetryPolicy());
        map.put(IOException.class, simpleRetryPolicy());
        map.put(ForestRuntimeException.class, simpleRetryPolicy());

        ExceptionClassifierRetryPolicy classifierRetryPolicy = new ExceptionClassifierRetryPolicy();
        classifierRetryPolicy.setPolicyMap(map);
        return classifierRetryPolicy;
    }

    /**
     * 指数退避策略
     */
    private BackOffPolicy exponentialBackOffPolicy() {

        //指数回退，第一次回退1s，第二次回退2s
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(1000L);
        //指数级别
        exponentialBackOffPolicy.setMultiplier(2);
        return exponentialBackOffPolicy;
    }
}
