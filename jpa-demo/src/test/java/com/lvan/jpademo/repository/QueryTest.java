package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Department;
import com.lvan.jpademo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Slf4j
@SpringBootTest
class QueryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

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

    @Transactional
    @Rollback(value = false)
    @Test
    void testUpdateWithoutClear() {

        User user = userRepository.getById(1);
        log.info(user.getName());

        userRepository.update(1, "lvan");

        user = userRepository.getById(1);
        log.info(user.getName());

        assertThat(user).isNotNull();
    }

    /**
     * 没有使用flushAutomatically导致部门的更新丢失
     */
    @Transactional
    @Rollback(value = false)
    @Test
    void testUpdateAndClear() {

        User user = userRepository.getById(1);
        log.info(user.getName());

        Department department = departmentRepository.getById(1);
        department.setName("test modify");
        departmentRepository.save(department);

        userRepository.updateAndClear(1, "lvan");
        user = userRepository.getById(1);
        log.info(user.getName());

        assertThat(user).isNotNull();
    }

    /**
     * flushAutomatically = true， 保证了部门的更新不被丢失
     */
    @Transactional
    @Rollback(value = false)
    @Test
    void testUpdateAndClearAndFlush() {

        User user = userRepository.getById(1);
        log.info(user.getName());

        Department department = departmentRepository.getById(1);
        department.setName("test modify");
        departmentRepository.save(department);

        userRepository.updateAndClearAndFlush(1, "lvan");
        user = userRepository.getById(1);
        log.info(user.getName());

        assertThat(user).isNotNull();
    }

}
