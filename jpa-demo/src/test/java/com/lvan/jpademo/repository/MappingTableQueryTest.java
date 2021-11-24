package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Slf4j
@SpringBootTest
class MappingTableQueryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Test
    void testFindAll() {

        List<Department> departments = departmentRepository.findAll();
        log.info("Department size:{}", departments.size());
    }

    @Transactional
    @Test
    void testFindById() {

        Optional<Department> departmentOptional = departmentRepository.findById(1);

        Department department = departmentOptional.get();

        assertThat(department).isNotNull();
    }
}