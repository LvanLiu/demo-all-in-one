package com.lvan.httpclientdemo.config;

import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.interceptor.SpringInterceptorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Lvan
 * @since 2021/11/21
 */
@Configuration
public class CustomForestConfiguration {

    @Resource
    private ForestConfiguration forestConfiguration;
    @Autowired
    private SpringInterceptorFactory springInterceptorFactory;

    @PostConstruct
    public void init() {
        forestConfiguration.setInterceptorFactory(springInterceptorFactory);
    }

    @Bean
    public SpringInterceptorFactory springInterceptorFactory() {
        return new SpringInterceptorFactory();
    }
}
