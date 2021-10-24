package com.lvan.jpademo.config;

import com.lvan.jpademo.auditor.MyAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Configuration
public class AuditorConfig {

    @Bean
    public AuditorAware<Integer> auditorProvider() {
        return new MyAuditorAware();
    }
}
