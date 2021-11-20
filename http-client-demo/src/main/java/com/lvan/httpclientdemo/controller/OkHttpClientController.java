package com.lvan.httpclientdemo.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@RestController
@RequestMapping("/okhttp")
public class OkHttpClientController {

    private final OkHttpClient okHttpClient;

    public OkHttpClientController(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @RequestMapping("hello")
    public String get() {
        Request request = new Request.Builder()
                .url("http://localhost:9999/world")
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            return responseBody.string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
