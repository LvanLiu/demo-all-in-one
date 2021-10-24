package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class AuditingRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void addRole() {

        Role role = new Role();
        role.setName("admin");

        roleRepository.save(role);
    }
}