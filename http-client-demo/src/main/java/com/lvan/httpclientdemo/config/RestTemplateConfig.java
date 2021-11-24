package com.lvan.httpclientdemo.config;

import com.lvan.httpclientdemo.interceptor.RestTemplateRetryInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

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
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, RetryTemplate retryTemplate) {
        return builder.setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .additionalInterceptors(new RestTemplateRetryInterceptor(retryTemplate))
                .uriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:9999"))
                .build();
    }
}
