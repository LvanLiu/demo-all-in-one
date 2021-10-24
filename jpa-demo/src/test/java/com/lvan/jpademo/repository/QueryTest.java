package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class QueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testJPQLPage() {

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> users = userRepository.selectAll(pageRequest);

        assertThat(users).isNotNull();
    }

    @Test
    void testNativeQueryPage() {

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> users = userRepository.nativeSelectAll(pageRequest);

        assertThat(users).isNotNull();
    }
}
