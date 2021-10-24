package com.lvan.jpademo.auditor;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Lvan
 * @since 2021/10/24
 */
public class MyAuditorAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(1);
    }
}
