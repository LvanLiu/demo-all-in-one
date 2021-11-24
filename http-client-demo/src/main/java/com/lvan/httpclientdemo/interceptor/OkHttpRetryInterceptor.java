package com.lvan.httpclientdemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;

/**
 * @author lvan
 * @date 2021/11/22
 */
@Slf4j
public class OkHttpRetryInterceptor implements Interceptor {

    private final RetryTemplate retryTemplate;

    public OkHttpRetryInterceptor(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return retryTemplate.execute(context -> {
            if (context.getRetryCount() > 0) {
                log.info("host:{} url:{} retry count:{}", chain.request().url().host(), chain.request().url().encodedPath(), context.getRetryCount());
            }
            return chain.proceed(chain.request());
        });
    }
}
