package com.lvan.jpademo.crud.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author lvan
 * @date 2021/10/8
 */
@SpringBootTest
class UserCrudRepositoryTest {

    @Resource
    private UserCrudRepository userCrudRepository;

    @Test
    void testFindAll() {

        Iterable<User> users = userCrudRepository.findAll();
        assertThat(users).isNotNull();
    }
}