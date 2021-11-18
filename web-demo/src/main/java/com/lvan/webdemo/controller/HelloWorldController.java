package com.lvan.webdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvan
 * @date 2021/11/18
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/world")
    public String hello() {
        return "hello world";
    }
}
