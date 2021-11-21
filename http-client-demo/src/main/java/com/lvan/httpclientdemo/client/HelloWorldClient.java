package com.lvan.httpclientdemo.client;

import com.dtflys.forest.annotation.Request;
import com.lvan.httpclientdemo.interceptor.ForestMetricsEventInterceptor;

/**
 * @author Lvan
 * @since 2021/11/21
 */
public interface HelloWorldClient {

    @Request(url = "http://localhost:9999/world", interceptor = ForestMetricsEventInterceptor.class)
    String getWorld();
}
