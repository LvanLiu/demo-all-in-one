package com.lvan.promethuesdemo.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvan
 * @date 2021/11/16
 */
@RestController
@RequestMapping
public class HelloWorldController {

    private final MeterRegistry meterRegistry;
    private final RestTemplate restTemplate;

    public HelloWorldController(MeterRegistry meterRegistry, RestTemplateBuilder restTemplateBuilder) {
        this.meterRegistry = meterRegistry;
        restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        meterRegistry.counter("hello-world", "status", "error", "path", "/hello").increment();
        String result = restTemplate.getForObject("http://localhost:8081/hello/world", String.class);
        return "Hello World";
    }

    @GetMapping("hello2")
    public String helloWorld2() {
        return "Hello World";
    }
}
