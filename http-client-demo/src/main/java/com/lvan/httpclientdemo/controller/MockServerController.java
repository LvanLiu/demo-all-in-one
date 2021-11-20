package com.lvan.httpclientdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
@RestController
@RequestMapping
public class MockServerController {

    @RequestMapping("world")
    public String getWorld() {
        log.info("get world");
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "hello world";
    }
}
