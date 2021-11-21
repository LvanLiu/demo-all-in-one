package com.lvan.httpclientdemo.controller;

import com.lvan.httpclientdemo.client.HelloWorldClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lvan
 * @since 2021/11/21
 */
@RestController
@RequestMapping("forest")
public class ForestController {

    private final HelloWorldClient helloWorldClient;
    private final RetryTemplate retryTemplate;

    public ForestController(HelloWorldClient helloWorldClient, RetryTemplate retryTemplate) {
        this.helloWorldClient = helloWorldClient;
        this.retryTemplate = retryTemplate;
    }

    @HystrixCommand
    @GetMapping("hello")
    public String helloWorld() {
       return retryTemplate.execute(context -> helloWorldClient.getWorld());
    }
}
