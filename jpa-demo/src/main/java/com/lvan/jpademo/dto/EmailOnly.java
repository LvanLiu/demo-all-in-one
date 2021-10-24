package com.lvan.jpademo.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Lvan
 * @since 2021/10/24
 */
public interface EmailOnly {

    String getEmail();

    @Value("#{target.name + '-' + target.age}")
    String getNameAndAge();
}
