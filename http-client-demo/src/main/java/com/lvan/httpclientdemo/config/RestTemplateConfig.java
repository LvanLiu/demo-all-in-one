package com.lvan.httpclientdemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 加上@LoadBalanced注解，让restTemplate使用上ribbon的超时重试功能.
     * 这里使用RestTemplateBuilder来设置连接超时时间、以及读超时时间，
     * 这里给一个很小的值，以测试超时的情况，因为要测试超时重试。
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .build();
    }
}
