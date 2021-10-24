package com.lvan.jpademo.repository;

import com.lvan.jpademo.dto.EmailOnly;
import com.lvan.jpademo.dto.UserNameDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Slf4j
@SpringBootTest
class ProjectionsTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testDto() {

        UserNameDto userNameDto = userRepository.findByEmail("xxxx@qq.com");
        assertThat(userNameDto).isNotNull();
    }

    @Test
    void testInterfaces() {

        EmailOnly emailOnly = userRepository.findByName("test");

        log.info(emailOnly.getEmail());
        log.info(emailOnly.getNameAndAge());

        assertThat(emailOnly.getEmail()).isNotNull();
        assertThat(emailOnly.getNameAndAge()).isNotNull();
    }
}
