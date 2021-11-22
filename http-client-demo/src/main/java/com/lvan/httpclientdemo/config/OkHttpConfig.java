package com.lvan.httpclientdemo.config;

import com.lvan.httpclientdemo.interceptor.OkHttpRetryInterceptor;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.okhttp3.OkHttpMetricsEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Configuration
public class OkHttpConfig {

    private final MeterRegistry meterRegistry;

    public OkHttpConfig(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    /**
     * 可以将eventListener来配置okHttp的指标捕获。
     */
    @Bean
    public okhttp3.OkHttpClient okHttpClient(OkHttpRetryInterceptor okHttpRetryInterceptor) {
        return new okhttp3.OkHttpClient.Builder()
                .eventListener(OkHttpMetricsEventListener.builder(meterRegistry, "okhttp.request").build())
                .retryOnConnectionFailure(false)
                .addInterceptor(okHttpRetryInterceptor)
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public OkHttpRetryInterceptor okHttpRetryInterceptor(RetryTemplate retryTemplate) {
        return new OkHttpRetryInterceptor(retryTemplate);
    }
}
