package com.lvan.httpclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableHystrix
@SpringBootApplication
public class HttpClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpClientDemoApplication.class, args);
    }

}
