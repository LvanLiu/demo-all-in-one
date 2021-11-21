package com.lvan.httpclientdemo;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.retry.annotation.EnableRetry;

@ForestScan(basePackages = "com.lvan.httpclientdemo.client")
@EnableRetry
@EnableHystrix
@SpringBootApplication
public class HttpClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpClientDemoApplication.class, args);
    }

}
