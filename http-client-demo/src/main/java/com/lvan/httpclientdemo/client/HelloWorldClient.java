package com.lvan.httpclientdemo.client;

import com.dtflys.forest.annotation.Request;

/**
 * @author Lvan
 * @since 2021/11/21
 */
public interface HelloWorldClient {

    @Request(url = "http://localhost:9999/world")
    String getWorld();
}
