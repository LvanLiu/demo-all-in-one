package com.lvan.jpademo.service.impl;

import com.lvan.jpademo.entity.User;
import com.lvan.jpademo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lvan
 * @since 2021/10/10
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Transactional
    @Rollback(value = false)
    @Test
    void userRegister() {

        User user = new User();
        user.setName("admin");
        user.setAge(18);
        user.setEmail("xxxx@qq.com");

        user = userService.userRegister(user);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
    }

    @Test
    void fetchUserById() {

        User user = userService.fetchUser(1);
        assertThat(user).isNotNull();
    }

    @Test
    void userAgeGrow() {

        User user = userService.userAgeGrow(1);
        assertThat(user).isNotNull();
    }

    @Test
    void fetchAllUsersBySortAge() {

        List<User> users = userService.fetchAllUsersBySortAge();
        assertThat(users.size()).isGreaterThan(1);
    }

    @Test
    void fetchUsersByPage() {

        Page<User> usersByPage = userService.fetchUsersByPage(0, 1);

        assertThat(usersByPage).isNotNull();
        assertThat(usersByPage.getTotalElements()).isGreaterThan(1);
    }
}