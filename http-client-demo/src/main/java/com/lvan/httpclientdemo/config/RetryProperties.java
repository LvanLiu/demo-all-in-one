package com.lvan.httpclientdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvan
 * @date 2021/11/23
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "retry")
public class RetryProperties {

    private int MaxAutoRetries = 3;
}
