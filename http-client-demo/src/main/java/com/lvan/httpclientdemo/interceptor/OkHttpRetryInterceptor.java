package com.lvan.httpclientdemo.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;

/**
 * @author lvan
 * @date 2021/11/22
 */
public class OkHttpRetryInterceptor implements Interceptor {

    private final RetryTemplate retryTemplate;

    public OkHttpRetryInterceptor(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return retryTemplate.execute(context -> chain.proceed(chain.request()));
    }
}
