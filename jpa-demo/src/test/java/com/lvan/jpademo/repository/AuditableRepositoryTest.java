package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Role;
import com.lvan.jpademo.entity.Role2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class AuditableRepositoryTest {

    @Autowired
    private Role2Repository roleRepository;

    @Test
    void testAuditable() {

        Role2 role = new Role2();
        role.setName("sub admin");

        roleRepository.save(role);
    }
}