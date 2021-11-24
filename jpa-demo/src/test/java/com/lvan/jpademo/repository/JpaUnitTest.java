package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import com.lvan.jpademo.enums.GenderEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lvan
 * @date 2021/11/24
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaUnitTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setEmail("xxxx@qq.com");
        user.setName("h2 test");
        user.setDate(new Date());
        user.setGender(GenderEnum.MALE);
        user = userRepository.save(user);
    }

    @Test
    void findById() {

        Optional<User> optional = userRepository.findById(1);
        User user = optional.get();
        assertThat(user).isNotNull();
    }
}
