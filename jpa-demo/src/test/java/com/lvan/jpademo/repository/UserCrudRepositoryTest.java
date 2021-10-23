package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
class UserCrudRepositoryTest {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * 测试用户信息
     */
    @Test
    void save() {

        User user = new User();
        user.setAge(18);
        user.setEmail("xxxx@qq.com");
        user.setName("test");
        user.setDate(new Date());

        user = userCrudRepository.save(user);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
    }
}