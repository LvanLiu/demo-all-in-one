package com.lvan.httpclientdemo.config;

import okhttp3.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool(200, 5, TimeUnit.MINUTES);
    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                .connectionPool(connectionPool())
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .build();
    }
}
