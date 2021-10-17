package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lvan
 * @since 2021/10/17
 */
@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void save() {

        Department department = new Department();
        department.setName("unit-test");
        department.setParentId(0);
        department.setSort(100);

        departmentRepository.save(department);
    }
}