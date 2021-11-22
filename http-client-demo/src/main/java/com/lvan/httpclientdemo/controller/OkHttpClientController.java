package com.lvan.httpclientdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
@RestController
@RequestMapping("/okhttp")
public class OkHttpClientController {

    private final OkHttpClient okHttpClient;
    private final RetryTemplate retryTemplate;

    public OkHttpClientController(OkHttpClient okHttpClient, RetryTemplate retryTemplate) {
        this.okHttpClient = okHttpClient;
        this.retryTemplate = retryTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("hello")
    public String helloWorld() throws IOException {
        Request request = new Request.Builder()
                .url("http://localhost:9999/world")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        ResponseBody responseBody = response.body();
        return responseBody.string();
    }

    public String fallback() {
        return "error fallback";
    }
}
