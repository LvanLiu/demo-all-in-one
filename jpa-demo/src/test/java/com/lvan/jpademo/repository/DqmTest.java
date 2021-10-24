package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class DqmTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindFirst() {

        User user = userRepository.findFirstByOrderByAgeDesc();

        assertThat(user).isNotNull();
    }

    @Test
    void testFindTop2() {

        List<User> users = userRepository.findTop2ByOrderByAgeDesc();

        assertThat(users).isNotNull();
    }
}
