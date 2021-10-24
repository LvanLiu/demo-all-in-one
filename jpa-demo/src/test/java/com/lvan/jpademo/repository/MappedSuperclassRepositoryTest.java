package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Role3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class MappedSuperclassRepositoryTest {

    @Autowired
    private Role3Repository roleRepository;

    @Test
    void addRole() {

        Role3 role = new Role3();
        role.setName("admin");

        roleRepository.save(role);
    }
}