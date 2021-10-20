package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lvan
 * @date 2021/10/18
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    void findById() {

        User user = userRepository.getById(1);
        user.setAge(99);
        User user2 = userRepository.getById(1);
        System.out.println();
    }
}