package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import com.lvan.jpademo.enums.GenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
class CrudRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testInsert() {
        User user = new User();
        user.setAge(18);
        user.setEmail("xxxx@qq.com");
        user.setName("test");
        user.setDate(new Date());
        user.setGender(GenderEnum.MALE);
        user = userRepository.save(user);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void testUpdate() {
        //这里会产生一条SQL语句，使用事务注解后，这里查询的结果会被缓存起来，再调用下面的save方法时，就不会触发多一次的查询了。
        Optional<User> userOptional = userRepository.findById(1);

        userOptional.ifPresent(user -> {
            user.setAge(user.getAge() + 1);
            //这里会产生一条SQL语句，一条Update语句
            userRepository.save(user);
        });

        assertThat(userOptional).isPresent();
    }

    /**
     * 使用CrudRepositoy的findById方法,并非懒加载方式,使用JpaRepository#getById方法就是懒加载的方式.
     */
    @Test
    void testFindById() {
        Optional<User> userOptional = userRepository.findById(1);
        assertThat(userOptional).isPresent();
    }

    @Transactional
    @Test
    void testFindAll() {
        List<User> userList = userRepository.findAll();

        assertThat(userList).isNotNull();
        assertThat(userList.size()).isGreaterThan(0);
    }

    /**
     * deleteById 会先根据id进行查询, 若存在,再进行删除.
     * deleteAllById: 循环调用deleteById方法
     */
    @Test
    void testDeleteById() {
        userRepository.deleteById(1);
    }

    /**
     * 调用delete方法,传入的Entity如果存在主键id,那么它的原理与deleteById一样,
     * 如果Entity的主键id为 null, 那么delete方法不会生效
     */
    @Test
    void testDelete() {

        Optional<User> userOptional = userRepository.findById(1);

        userOptional.ifPresent(user -> {
            user.setId(null);
            userRepository.delete(user);
        });
    }
}