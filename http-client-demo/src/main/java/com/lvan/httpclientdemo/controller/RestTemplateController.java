package com.lvan.httpclientdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@RestController
@RequestMapping("rest")
public class RestTemplateController {

    private final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("hello")
    public String hello() {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/world", String.class);
        return responseEntity.getBody();
    }

    public String fallback() {
        return "error fallback";
    }
}
