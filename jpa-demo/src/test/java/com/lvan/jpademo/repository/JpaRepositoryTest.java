package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
class JpaRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAll() {

        User user = new User();
        user.setAge(18);
        user.setEmail("xxxx@qq.com");
        user.setName("test");
        user.setDate(new Date());

        List<User> users = userRepository.saveAll(Collections.singletonList(user));

        assertThat(users).isNotNull();
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void testFlush() {

        User user = userRepository.getById(2);

        //更新年龄
        int orgAge = user.getAge();
        int nowAge = orgAge + 1;
        user.setAge(nowAge);

        //调用flush()方法，将以上更新刷新到缓存中
        userRepository.flush();

        assertThat(user).isNotNull();
        assertThat(user.getAge()).isEqualTo(nowAge);
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void testSaveFlushWithIdEntity() {

        User user = userRepository.getById(2);

        //更新年龄
        int orgAge = user.getAge();
        int nowAge = orgAge + 1;
        user.setAge(nowAge);

//        userRepository.save(user);
        userRepository.saveAndFlush(user);

        assertThat(user).isNotNull();
        assertThat(user.getAge()).isEqualTo(nowAge);
    }

    @Test
    void testDeleteAllByIdInBatch() {

        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);

        userRepository.deleteAllByIdInBatch(ids);
    }

    @Test
    void testDeleteByName() {

        userRepository.deleteByName("test");
    }
}
