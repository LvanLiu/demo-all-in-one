package com.lvan.httpclientdemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.retry.support.RetryTemplate;

import java.io.IOException;

/**
 * @author lvan
 * @date 2021/11/23
 */
@Slf4j
public class RestTemplateRetryInterceptor implements ClientHttpRequestInterceptor {

    private final RetryTemplate retryTemplate;

    public RestTemplateRetryInterceptor(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body,
                                        final ClientHttpRequestExecution execution) throws IOException {
        return retryTemplate.execute(context -> {
            log.info("host:{} url:{} retry count:{}", request.getURI().getHost(), request.getURI().getPath(), context.getRetryCount());
            return execution.execute(request, body);
        });
    }
}
